
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

public class DisposeInProcessActivity extends AppCompatActivity {
    public static final String TAG = DisposeInProcessActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispose_in_process);
        doRxjavaWork();
    }

    private void doRxjavaWork() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e) throws Exception {
                e.onNext(0);
                Log.d(TAG, "onNext0");
                e.onNext(1);
                Log.d(TAG, "onNext1");
                e.onNext(2);
                Log.d(TAG, "onNext2");
                e.onNext(3);
                Log.d(TAG, "onNext3");
                e.onNext(4);
                Log.d(TAG, "onNext4");
                e.onComplete();
                Log.d(TAG, "onComplete");

            }
        }).subscribe(new Observer<Integer>() {
            Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;

            }

            @Override
            public void onNext(Integer integer) {
                Log.d(TAG, "onNext: " + integer);
                if (integer > 2) {
                    mDisposable.dispose();
                    Log.d(TAG, "切断水管");
                }
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
