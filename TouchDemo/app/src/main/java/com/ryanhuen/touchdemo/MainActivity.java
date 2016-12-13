
package com.ryanhuen.touchdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        String action = null;
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "Down";
                break;
            case MotionEvent.ACTION_UP:
                action = "up";
                break;
            case MotionEvent.ACTION_MOVE:
                action = "move";
                break;
        }
        System.out.println("MainActivity.dispatchTouchEvent : " + action);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        String action = null;
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                action = "Down";
                break;
            case MotionEvent.ACTION_UP:
                action = "up";
                break;
            case MotionEvent.ACTION_MOVE:
                action = "move";
                break;
        }
        System.out.println("MainActivity.onTouchEvent : "+action);
        return super.onTouchEvent(event);
    }
}
