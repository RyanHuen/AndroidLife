
package com.ryanhuen.rxjava2demo.thread_control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class MultiThreadChangeActivity extends AppCompatActivity {
    public static final String TAG = MultiThreadChangeActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_thread_change);
        doRxjavaWork();
    }

    private void doRxjavaWork() {
        // 创建一个上游的Observable（被观察者）
        Observable<String> observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e/* 事件发射器 */) throws Exception {
                // 发射事件
                Log.d(TAG, "Observable thread is :" + Thread.currentThread().getName());
                e.onNext("事件1");
                e.onNext("事件2");
                e.onNext("事件3");
                e.onComplete();
            }
        });

        // 创建一个下游Observer（观察者）
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(/**/Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String string) {
                Log.d(TAG, "onNext: " + string);
                Log.d(TAG, "Observer thread is :" + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        };
        // 上下游建立连接（观察者被观察者建立联系）
        observable
                .subscribeOn(Schedulers.newThread())
                .subscribeOn(Schedulers.io())/* 此次切换无效 */
                .observeOn(Schedulers.newThread())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        Log.d(TAG, "After observeOn(NewThread),current thread is:"
                                + Thread.currentThread().getName());

                    }
                })
                .observeOn(Schedulers.io())
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        Log.d(TAG, "After observeOn(io),current thread is:"
                                + Thread.currentThread().getName());

                    }
                })
                .observeOn(AndroidSchedulers.mainThread()/* 指定下游接收事件的Thread */)
                .doOnNext(new Consumer<String>() {
                    @Override
                    public void accept(String string) throws Exception {
                        Log.d(TAG, "After observeOn(mainThread),current thread is:"
                                + Thread.currentThread().getName());

                    }
                })
                .subscribe(observer);
    }
}
