
package com.ryanhuen.touchdemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by ryanhuencompany on 16-12-13.
 */

public class BaseImageView extends ImageView {
    public BaseImageView(Context context) {
        super(context);
    }

    public BaseImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
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
        System.out.println("BaseImageView.dispatchTouchEvent : " + action);
        return super.dispatchTouchEvent(event);
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
        System.out.println("BaseImageView.onTouchEvent : " + action);
        return super.onTouchEvent(event);
    }
}
