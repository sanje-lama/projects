package com.example.stl.unittworeview_dayone;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.net.URI;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity stl";
    private EditText editText;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null) {
            editText.setText(savedInstanceState.getString("Edit Text"));
        }





    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "I am onStart ");
    }


    //THe state your app is in. Can be used after onPause and
    protected void onResume() {
        Log.d(TAG, "I am on onResume");

        super.onResume();
    }

    protected void onPause() {
        Log.d(TAG, "I am onPause");
        super.onPause();

    }

    protected void onStop() {
        super.onStop();
        Log.d(TAG, "I am onStop");
    }

    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "I am onDestroy");
    }



    public void buttonSaysGo(View view) {
        Uri uri = Uri.parse("tel: 12345678");
        Intent intent = new Intent(Intent.ACTION_DIAL, uri);

//        Intent intent = new Intent(MainActivity.this, NavActivity.class);
//        intent.putExtra("name", "Stl");
//
        startActivity(intent);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        editText.getText().toString();
        outState.putString("Edit Text", editText.getText().toString());

    }
}
