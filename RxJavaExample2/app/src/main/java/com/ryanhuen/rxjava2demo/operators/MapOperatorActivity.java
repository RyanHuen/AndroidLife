
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
        }).map(new Function<String, String>() {
            @Override
            public String apply(String string) throws Exception {
                // 通过变换操作，拼接字符串，随后返回
                return "变换后的结果：" + string;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                Log.d(TAG, s);
            }
        });

    }

}
