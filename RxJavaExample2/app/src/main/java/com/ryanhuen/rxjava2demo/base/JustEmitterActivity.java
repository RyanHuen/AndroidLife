
package com.ryanhuen.rxjava2demo.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class JustEmitterActivity extends AppCompatActivity {
    public static final String TAG = JustEmitterActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_emitter);
        doRxJavaWork();
    }

    private void doRxJavaWork() {
        Observable.just(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
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
        });

    }
}
