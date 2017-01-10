
package com.ryanhuen.rxjava2demo.operators;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class ConcatMapOperatorActivity extends AppCompatActivity {
    public static final String TAG = ConcatMapOperatorActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_concat_map_operator);
        doRxJavaWork();
    }

    private void doRxJavaWork() {
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> e/* 事件发射器 */) throws Exception {
                e.onNext(1);
                e.onNext(2);
                e.onNext(3);
                e.onNext(4);
                e.onComplete();
            }
        }).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                final List<String> list = new ArrayList<String>();
                for (int i = 0; i < 3; i++) {
                    list.add("I am value:" + integer);
                }
                return Observable.fromIterable(list)/*
                                                     * 后续代码加入了delay功能，
                                                     * 标示发送事件延迟10毫秒
                                                     */.delay(10, TimeUnit.MILLISECONDS);
            }

        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept: " + s);

            }
        });
    }
}
