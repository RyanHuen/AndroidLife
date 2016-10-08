
package com.chaozhuo.permissionrequest;

import android.Manifest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ryanhuenwork on 16-10-8.
 */
public class Config {
    /**
     * config your permission list here
     */
    public static final List<String> PERMISSION_LIST = new ArrayList<>(
            Arrays.asList(Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE));
}
