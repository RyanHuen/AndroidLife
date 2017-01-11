
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

public class LineHandleActivity extends AppCompatActivity {
    public static final String TAG = LineHandleActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_handle);
        doRxJavaWork();
    }

    private void doRxJavaWork() {
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> e/* 事件发射器 */) throws Exception {
                Log.d(TAG, "上游调用onNext1");
                e.onNext("事件1");
                Log.d(TAG, "上游调用onNext2");
                e.onNext("事件2");
                Log.d(TAG, "上游调用onNext3");
                e.onNext("事件3");
                Log.d(TAG, "上游调用onNext4");
                e.onNext("事件4");
                Log.d(TAG, "上游调用onComplete");
                e.onComplete();

            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: ");
            }

            @Override
            public void onNext(String string) {
                Log.d(TAG, "下游onNext: " + string);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "下游onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "下游onComplete: ");
            }
        });

    }

}
