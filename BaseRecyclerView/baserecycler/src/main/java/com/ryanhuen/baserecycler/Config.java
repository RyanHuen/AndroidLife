
package com.ryanhuen.baserecycler;

import android.os.Environment;

import java.io.File;

/**
 * Created by ryanhuenwork on 16-10-21.
 */

public class Config {
    public static final int ViewTypeGrid = 2;
    public static final int ViewTypeSimpleList = 3;
    public static final int ViewTypeDoubleLineList = 4;
    public static final String DIR_EXTERNAL_STORAGE = Environment
            .getExternalStorageDirectory().getAbsolutePath() + File.separator;
}
