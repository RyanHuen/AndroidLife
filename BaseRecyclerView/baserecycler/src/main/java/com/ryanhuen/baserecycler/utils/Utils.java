
package com.ryanhuen.baserecycler.utils;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by ryanhuenwork on 16-10-21.
 */

public class Utils {

    public static Point getScreenSize(Context ctx) {
        return getSizeFromDisplayMetrics(ctx);
    }

    public static Point getSizeFromDisplayMetrics(Context ctx) {
        DisplayMetrics dm = ctx.getResources().getDisplayMetrics();

        if (dm == null) {
            return new Point(0, 0);
        } else {
            return new Point(dm.widthPixels, dm.heightPixels);
        }
    }
}
