
package com.ryanhuen.rxjava2demo.flowable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;

public class BaseFlowableActivity extends AppCompatActivity {
    public static final String TAG = BaseFlowableActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_flowable);
        doRxJavaWork();
    }

    private void doRxJavaWork() {
        Flowable<String> flowable = Flowable.create(new FlowableOnSubscribe<String>() {
            @Override
            public void subscribe(FlowableEmitter<String> e) throws Exception {
                e.onNext("事件1");
                e.onNext("事件2");
                e.onNext("事件3");
                e.onNext("事件4");
                e.onComplete();
            }
        }, BackpressureStrategy.ERROR);

        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                Log.d(TAG, "onSubscribe: ");
                s.request(Long.MAX_VALUE);

            }

            @Override
            public void onNext(String string) {
                Log.d(TAG, "onNext: " + string);
            }

            @Override
            public void onError(Throwable t) {
                Log.d(TAG, "onError: " + t.toString());
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "onComplete: ");

            }
        };

        flowable.subscribe(subscriber);
    }
}
