
package com.ryanhuen.rxjava2demo.operators;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;

public class ZipOperatorActivity extends AppCompatActivity {
    public static final String TAG = ZipOperatorActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zip_operator);
        doRxJavaWork();
    }

    private void doRxJavaWork() {
        Observable<Integer> observable1 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e/* 事件发射器 */) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());
        Observable<Integer> observable2 = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e/* 事件发射器 */) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onComplete();
            }
        }).subscribeOn(Schedulers.io());
        Observable.zip(observable1, observable2, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        }).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(/**/Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "zip操作结果: " + integer);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");

            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        });

    }
}
