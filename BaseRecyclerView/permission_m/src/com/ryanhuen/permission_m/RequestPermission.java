
package com.ryanhuen.permission_m;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;

/**
 * Created by ryanhuenwork on 16-10-13. Request Permission in Marshmallow or
 * higher
 */
public class RequestPermission {
    public static final int CODE_FOR_MULTIPLE_PERMISSION = 10;

    public static void verifyPermissions(Activity activity) {
        List<String> permissionsNeeded = new ArrayList<>();
        List<String> CONFIG_PERMISSION_LIST = PermissionConfig.getPermissionList();

        if (Build.VERSION.SDK_INT >= 23) {
            for (String perm : CONFIG_PERMISSION_LIST) {
                // Check if we have write permission
                int permission = ActivityCompat.checkSelfPermission(activity, perm);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    permissionsNeeded.add(perm);
                }
            }
        }

        if (permissionsNeeded.size() > 0) {
            ActivityCompat.requestPermissions(
                    activity,
                    permissionsNeeded.toArray(new String[permissionsNeeded.size()]),
                    CODE_FOR_MULTIPLE_PERMISSION);
        }
    }

}
