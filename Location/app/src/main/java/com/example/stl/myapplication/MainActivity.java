package com.example.stl.myapplication;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_LOCATION_PERMISSION = 123;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final PermissionHelper permissionHelper = new PermissionHelper();

        if (permissionHelper.check(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            final FusedLocationProviderClient flpClient = LocationServices.getFusedLocationProviderClient(this);
            flpClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
                @Override
                public void onSuccess(Location location) {
                    final String latLong = "Latitude: " + location.getLatitude() + " Longitude: " + location.getLongitude();
                    Log.d(TAG, latLong);
                    ((TextView)findViewById(R.id.activity_main_latLong)).setText(latLong);

                    new FetchAddressTask(MainActivity.this).execute(location);
                }
            });
            flpClient.getLastLocation().addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Log.d(TAG, e.getMessage());
                }
            });
        }
    }

    /**
     * This method gets called EVERY TIME the user answers a permission dialog created in this Activity.
     * It's YOUR job to parse through all the permissions/granted results to find the right one.
     * <p>
     * Line 42:
     * Depending on which requestCode,
     * <p>
     * Line 44, 48:
     * if the user answer is granted, then show a Toast.
     * otherwise, show a Toast and close MainActivity.
     *
     * @param requestCode  : The code you specified on line 31:
     * @param permissions  : The permissions you passed in on line 19 (The ones you want granted)
     * @param grantResults : What the user answered for the permissions dialog for EACH permission you requested
     * @see PermissionHelper#check(android.app.Activity, java.lang.String)
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_PERMISSION: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // Permission was granted...
                    Toast.makeText(getApplicationContext(), "Permission granted! ", Toast.LENGTH_SHORT).show();
                } else {

                    // Permission was denied...
                    Toast.makeText(getApplicationContext(), "Permission denied! ", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            }
        }
    }

    /**
     * ASyncTask parameters: <Input, in-Progress Output, Final Output>
     *
     * method doInBackground(): What you want your ASyncTask to do in the background thread.
     * In our case, we want it to do a network request to get our address using our Lat & Long.
     * We want to "transform" our location input parameter into a String output via
     * Location (lat/long) ---> geocoder.getFromLocation() ---> String (address).
     *
     * method onPostExecute(): Gets called when doInBackround is done. Type String
     * gets passed in from doInBackgrounds' return.
     *
     * Location (lat/long) --> geocoder.getFromLocation() --> String (address) --> onPostExecute --> show in UI.
     *
     * @see Locale
     * @see AsyncTask
     */
    private class FetchAddressTask extends AsyncTask<Location, Void, String> {
        private final String TAG = FetchAddressTask.class.getSimpleName();
        private final Geocoder geocoder;

        FetchAddressTask(@NonNull Context context) {
            geocoder = new Geocoder(context, Locale.getDefault());
        }

        @Override
        protected String doInBackground(Location... locations) {
            String returnAddress = "";

            try {
                final List<Address> addressList = geocoder.getFromLocation(
                        locations[0].getLatitude(),
                        locations[0].getLongitude(),
                        1);

                if (addressList == null || addressList.size() == 0) {
                    Log.e(TAG, "Geocoder response error");
                    return "No address found";
                }

                returnAddress = addressList.get(0).getAddressLine(0);
            } catch (IOException e) {
                Log.e(TAG, e.getMessage());
            }

            return returnAddress;
        }

        @Override
        protected void onPostExecute(String output) {
            super.onPostExecute(output);
            ((TextView)findViewById(R.id.activity_main_address)).setText(output);
        }
    }
}