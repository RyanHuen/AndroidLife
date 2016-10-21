
package com.ryanhuen.permission_m;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by ryanhuenwork on 16-10-13.
 */
public class PermissionConfig {
    /**
     * configure your permission here
     */
    private static final List<String> PERMISSION_LIST = new ArrayList<String>();

    public static List<String> getPermissionList() {
        return PERMISSION_LIST;
    }

    public static void removeFromPermissionList(String permissionString) {
        PERMISSION_LIST.remove(permissionString);
    }

    public static void addToPermissionList(String permissionString) {
        PERMISSION_LIST.add(permissionString);
    }

    public static void addToPermissionList(String[] permissionArray) {
        PERMISSION_LIST.addAll(Arrays.asList(permissionArray));
    }

    public static void addToPermissionList(Collection<? extends String> permissionList) {
        PERMISSION_LIST.addAll(permissionList);
    }

    public static void clearAllPermission() {
        PERMISSION_LIST.clear();
    }

}
