package com.example.stl.myapplication;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static com.example.stl.myapplication.MainActivity.REQUEST_LOCATION_PERMISSION;

public class PermissionHelper {

    /**
     * Line 27:
     * Checks if user has granted the app the specific permission passed in. If yes, then return true.
     *
     * Line 31:
     * If user has NOT granted the app this specific permission passed in, ask Android to show permission dialog and return false.
     *
     * Used in:
     * @see MainActivity
     *
     * @param activity : "Binds" this method call to the passed in activity
     * @param permission : The specific permission we want granted/checked
     */
    public boolean check(@NonNull Activity activity,
                         @NonNull String permission) {
        if (ActivityCompat.checkSelfPermission(activity, permission) == PERMISSION_GRANTED) {
            return true;
        }

        ActivityCompat.requestPermissions(activity, new String[]{permission}, REQUEST_LOCATION_PERMISSION);
        return false;
    }
}
