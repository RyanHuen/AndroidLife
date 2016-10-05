
package com.chaozhuo.rxexample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.chaozhuo.rxexample.R;

import rx.Observable;
import rx.Subscriber;

public class BaseImplActivity extends AppCompatActivity {
    public static final String TAG = BaseImplActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_impl);
        /**
         * 观察者，接收被观察者发出的消息，在onNext()方法中进行处理
         */
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onStart() {
                super.onStart();
                Toast.makeText(BaseImplActivity.this, "我做准备工作，但是不能指定线程，我发生在订阅事件的线程中",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
                Toast.makeText(BaseImplActivity.this, "onCompleted: ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
                Toast.makeText(BaseImplActivity.this, "onError: ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
                Toast.makeText(BaseImplActivity.this, "onNext: " + s, Toast.LENGTH_SHORT).show();

            }
        };
        /**
         * 被观察者，由它发送事件（对象）
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                subscriber.onNext("1");
                subscriber.onNext("2");
                subscriber.onNext("3");
                subscriber.onNext("4");
                subscriber.onCompleted();
            }
        });

        /**
         * 实现订阅（注册观察），建立观察者和被观察者之间的联系
         */
        observable.subscribe(subscriber);
    }
}
