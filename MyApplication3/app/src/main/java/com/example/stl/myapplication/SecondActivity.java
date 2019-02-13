package com.example.stl.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ImageView img = findViewById(R.id.image_view);
        AppCompatTextView txt = findViewById(R.id.text_view);
        txt.setText( getIntent().getStringExtra("name"));
        int resId = getResources().getIdentifier(getIntent().getStringExtra("imgname"),"drawable", getPackageName());
        img.setImageDrawable(getResources().getDrawable(resId));
    }
}

