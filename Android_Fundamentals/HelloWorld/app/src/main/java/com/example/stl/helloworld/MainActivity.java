package com.example.stl.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;



    // AppCompactActivity inherited from support library
public class MainActivity extends AppCompatActivity {

   // private static final String LOG_TAG = MainActivity.class.getSimpleName();



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // This allows you use all the functionality provided
        // by your Parent class(AppCompactActivity)
        super.onCreate(savedInstanceState);
       // providing a view to you activity(layout xml)
        setContentView(R.layout.activity_main);

        Log.d("MainActivity", "Hello World");
    }
}
