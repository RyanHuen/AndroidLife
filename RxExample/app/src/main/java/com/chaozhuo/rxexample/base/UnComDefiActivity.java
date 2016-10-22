
package com.chaozhuo.rxexample.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.chaozhuo.rxexample.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action0;
import rx.functions.Action1;

public class UnComDefiActivity extends AppCompatActivity {
    public static final String TAG = UnComDefiActivity.class.getName();

    @Bind(R.id.just_onNext)
    Button mJustOnNext;
    @Bind(R.id.excpet_onCom)
    Button mExcpetOnCom;
    @Bind(R.id.include_all)
    Button mIncludeAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_un_com_defi);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.just_onNext, R.id.excpet_onCom, R.id.include_all
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.just_onNext:
                justOnNextAction();
                break;
            case R.id.excpet_onCom:
                exceptOnCompleted();
                break;
            case R.id.include_all:
                includeAll();
                break;
        }
    }

    private void includeAll() {
        Observable<String> observable = Observable.just("1", "2", "3", "4");

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call: " + s);
                Toast.makeText(UnComDefiActivity.this, "call: " + s,
                        Toast.LENGTH_SHORT)
                        .show();
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable e) {
                Log.d(TAG, "error: " + e);
                Toast.makeText(UnComDefiActivity.this, "error: " + e, Toast.LENGTH_SHORT).show();
            }
        };
        Action0 onCompletedAction = new Action0() {
            @Override
            public void call() {
                Log.d(TAG, "onCompleted: ");
                Toast.makeText(UnComDefiActivity.this, "onCompleted: ", Toast.LENGTH_SHORT).show();
            }
        };
        observable.subscribe(onNextAction, onErrorAction, onCompletedAction);

    }

    private void exceptOnCompleted() {
        Observable<String> observable = Observable.just("1", "22", "322", null);

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call: " + s);
                Toast.makeText(UnComDefiActivity.this, "call: " + s.substring(0, 1),
                        Toast.LENGTH_SHORT)
                        .show();
            }
        };
        Action1<Throwable> onErrorAction = new Action1<Throwable>() {
            @Override
            public void call(Throwable e) {
                Log.d(TAG, "error: " + e);
                Toast.makeText(UnComDefiActivity.this, "error: " + e, Toast.LENGTH_SHORT).show();
            }
        };
        observable.subscribe(onNextAction, onErrorAction);

    }

    private void justOnNextAction() {
        //被观察者
        Observable<String> observable = Observable.just("1", "2", "3", "4");

        Action1<String> onNextAction = new Action1<String>() {
            @Override
            public void call(String s) {
                Log.d(TAG, "call: " + s);
                Toast.makeText(UnComDefiActivity.this, "call: " + s, Toast.LENGTH_SHORT)
                        .show();
            }
        };
        observable.subscribe(onNextAction);
    }
}
