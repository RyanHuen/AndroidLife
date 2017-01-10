
package com.ryanhuen.rxjava2demo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BaseImplActivity extends AppCompatActivity {
    public static final String TAG = BaseImplActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_impl);
        doRxjavaWork();
    }

    private void doRxjavaWork() {
        // 创建一个上游的Observable（被观察者）
        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e/* 事件发射器 */) throws Exception {
                // 发射事件
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        });

        // 创建一个下游Observer（观察者）
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(/**/Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
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
        observable.subscribe(observer);
    }
}
