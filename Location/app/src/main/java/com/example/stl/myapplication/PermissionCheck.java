package com.example.stl.myapplication;

import android.app.Activity;
import android.content.pm.PackageManager;

import com.google.android.gms.instantapps.ActivityCompat;

public class PermissionCheck {

public void check(Activity activity, String permission) {

    //this only for the result. Checks if the user granted the app permissions
    if (android.support.v4.app.ActivityCompat.checkSelfPermission(activity, permission)
            == PackageManager.PERMISSION_GRANTED) {
        return;
    }
        android.support.v4.app.ActivityCompat.requestPermissions(activity, new String[]{permission},MainActivity.REQUEST_LOCATION_PERMISSION);
    }
}


