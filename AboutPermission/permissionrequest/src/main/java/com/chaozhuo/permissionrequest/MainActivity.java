
package com.chaozhuo.permissionrequest;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.verifyPermissions();
    }

    public static final int CODE_FOR_MULTIPLE_PERMISSION = 10;

    public void verifyPermissions() {
        List<String> permissionsNeeded = new ArrayList<>();
        List<String> CONFIG_PERMISSION_LIST = Config.PERMISSION_LIST;

        if (Build.VERSION.SDK_INT >= 23) {
            for (String perm : CONFIG_PERMISSION_LIST) {
                // Check if we have write permission
                int permission = ActivityCompat.checkSelfPermission(this, perm);
                if (permission != PackageManager.PERMISSION_GRANTED) {
                    // We don't have permission so prompt the user
                    permissionsNeeded.add(perm);
                }
            }
        }

        if (permissionsNeeded.size() > 0) {
            ActivityCompat.requestPermissions(
                    this,
                    permissionsNeeded.toArray(new String[permissionsNeeded.size()]),
                    CODE_FOR_MULTIPLE_PERMISSION);
        }
    }
}
