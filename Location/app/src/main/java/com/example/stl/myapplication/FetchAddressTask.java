package com.example.stl.myapplication;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

//Wrapper to run code
public class FetchAddressTask extends AsyncTask<Location, Void, String> {

    private final String TAG = FetchAddressTask.class.getSimpleName();

    private final Geocoder geocoder;

    // Passing context
    public FetchAddressTask(Context context) {
        geocoder = new Geocoder(context, Locale.getDefault());

    }



    // What you the async task to run in the background.
    // (...) how many location you want to pass in
    @Override
    protected String doInBackground(Location... locations) {

        String returnAdd = "";

        try {


        final List<Address> addressList =
        geocoder.getFromLocation(
                locations[0].getLatitude(),
                locations[0].getLongitude(),1);

                if (addressList == null && addressList.size() ==0) {
            Log.e(TAG, "error");
            return "No addressList found";
        }
        returnAdd = addressList.get(0).getAddressLine(0);
        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        }
        return returnAdd;


    //


        }

        //
    @Override
    protected void onPostExecute(String output) {
        super.onPostExecute(output);
    }
    }

