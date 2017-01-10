
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
        Observable.just("事件0", "事件1", "事件2", "事件3", "事件4", "事件5", "事件6", "事件7", "事件8", "事件9")
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(TAG, "onSubscribe: ");

                    }

                    @Override
                    public void onNext(String string) {
                        Log.d(TAG, "onNext: " + string);

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
