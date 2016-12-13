
package com.ryanhuen.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

/**
 * Created by ryanhuencompany on 16-12-13.
 */

public class BaseLinearLayout extends LinearLayout {
    public BaseLinearLayout(Context context) {
        super(context);
    }

    public BaseLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
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
        System.out.println("BaseLinearLayout.dispatchTouchEvent : " + action);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
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
        System.out.println("BaseLinearLayout.onInterceptTouchEvent : " + action);
        return super.onInterceptTouchEvent(ev);
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
        System.out.println("BaseLinearLayout.onTouchEvent : " + action);
        return super.onTouchEvent(event);
    }
}
