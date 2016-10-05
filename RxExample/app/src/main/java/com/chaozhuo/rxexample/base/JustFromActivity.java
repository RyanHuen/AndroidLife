
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
import rx.Subscriber;

public class JustFromActivity extends AppCompatActivity {
    public static final String TAG = JustFromActivity.class.getName();
    @Bind(R.id.just_key)
    Button mJustKey;
    @Bind(R.id.from_key)
    Button mFromKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_from);
        ButterKnife.bind(this);
    }

    @OnClick({
            R.id.just_key, R.id.from_key
    })
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.just_key:
                onJustKeyPush();
                break;
            case R.id.from_key:
                onFromKeyPush();
                break;
        }
    }

    private void onFromKeyPush() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
                Toast.makeText(JustFromActivity.this, "onCompleted: ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
                Toast.makeText(JustFromActivity.this, "onError: ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
                Toast.makeText(JustFromActivity.this, "onNext: " + s, Toast.LENGTH_SHORT).show();
            }
        };
        String[] strings = {
                "1", "2", "3", "4"
        };
        Observable<String> observable = Observable.from(strings);
        observable.subscribe(subscriber);
    }

    private void onJustKeyPush() {
        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                Log.d(TAG, "onCompleted: ");
                Toast.makeText(JustFromActivity.this, "onCompleted: ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError: ");
                Toast.makeText(JustFromActivity.this, "onError: ", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNext(String s) {
                Log.d(TAG, "onNext: " + s);
                Toast.makeText(JustFromActivity.this, "onNext: " + s, Toast.LENGTH_SHORT).show();
            }
        };
        Observable<String> observable = Observable.just("1", "2", "3", "4");
        observable.subscribe(subscriber);
    }
}
