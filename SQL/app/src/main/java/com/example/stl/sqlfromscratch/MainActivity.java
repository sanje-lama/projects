package com.example.stl.sqlfromscratch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.stl.sqlfromscratch.controller.SqlAdapter;
import com.example.stl.sqlfromscratch.database.NoteDatabase;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void goDataBasePage(View view) {
        Intent intent=new Intent(view.getContext(),SecondActivity.class);
        view.getContext().startActivity(intent);
    }

    public void goToReviewPage(View view) {
        Intent intent=new Intent(view.getContext(),ThirdActivity.class);
        view.getContext().startActivity(intent);
    }


}
