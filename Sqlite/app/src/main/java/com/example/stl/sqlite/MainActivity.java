package com.example.stl.sqlite;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        FellowsDatabaseHelper fellowsDatabaseHelper = new FellowsDatabaseHelper(this);

        fellowsDatabaseHelper.addFellow(new Fellow("S","L","JCA"));


       Log.i("LIST",fellowsDatabaseHelper.getFellowList().get(0).toString());
    }
}
