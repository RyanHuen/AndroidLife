package com.example.rxbus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            SubscriberFragment subscriberFragment = SubscriberFragment.newInstance();
            ObservableFragment observableFragment = ObservableFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fl_subscriber, subscriberFragment)
                    .add(R.id.fl_observable, observableFragment)
                    .commit();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
