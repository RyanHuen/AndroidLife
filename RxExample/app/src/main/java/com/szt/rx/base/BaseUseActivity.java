package com.szt.rx.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.chaozhuo.rxexample.R;

import rx.Observable;
import rx.Subscriber;

public class BaseUseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_use);
        //被观察者
//        Observable<Integer> observable =Observable.create(new Observable.OnSubscribe<Integer>() {
//            @Override
//            public void call(Subscriber<? super Integer> subscriber) {
//                subscriber.onNext(1);
//                subscriber.onNext(2);
//                subscriber.onNext(3);
//                subscriber.onNext(4);
//                subscriber.onNext(5);
//                subscriber.onCompleted();
//            }
//        });
        Observable<Integer> observable = Observable.just(1, 2, 3, 4, 5, 6);
//        Integer[] integers={1,2,3,4,5};
//        Observable<Integer> observable=Observable.from(integers);

        //观察者
        Subscriber<Integer> subscriber = new Subscriber<Integer>() {
            @Override
            public void onStart() {
                super.onStart();
                System.out.println("我在所有事件发射之前调用");
            }

            @Override
            public void onCompleted() {
                System.out.println("成功");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("失败" + e);

            }

            @Override
            public void onNext(Integer s) {
//                System.out.println("s = " + s);
                System.out.println(("" + s).substring(0, 2));

            }
        };
        observable.subscribe(subscriber);
    }
}
