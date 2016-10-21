
package com.ryanhuen.baserecycler;

import android.app.Application;
import android.content.Context;

/**
 * Created by ryanhuenwork on 16-10-21.
 */

public class MyApplication extends Application {
    private static Context sContext;

    public static Context getContext() {
        return sContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this.getApplicationContext();
    }
}
