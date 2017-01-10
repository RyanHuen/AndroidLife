
package com.ryanhuen.rxjava2demo.operators;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.chaozhuo.rxjava2demo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

public class MapOperatorActivity extends AppCompatActivity {
    public static final String TAG = MapOperatorActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_operator);
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
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                // 通过变换操作，将数字拼接上字符串，随后返回
                return "this is resule:" + integer;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, "accept: " + s);

            }
        });

    }

}
