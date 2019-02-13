package com.example.stl.fivefragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.stl.fivefragments.fragments.ButtonFragment;
import com.example.stl.fivefragments.fragments.MainFragment;
import com.example.stl.fivefragments.fragments.PictureFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        MainFragment mainFragment = new MainFragment();
//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.main_container, mainFragment);
//        fragmentTransaction.commit();

        ButtonFragment buttonFragment = new ButtonFragment();
        FragmentManager fragmentManager1 = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
        fragmentTransaction1.replace(R.id.main_container, buttonFragment);
        fragmentTransaction1.commit();

    }
// What are the benefits over an activity?
    // reuse ability,

    // Reducing waste.
    // view model in charge of putting the views
    // static factory doesn't mean you have one instance of the class. (Singleton)
    // Singleton = private..
    //

    // Architecture(MVC = model view controller,
    // MVVM = Model view view model, views are updated automatically.

    // controller decides what data is being sent to which view
    // view

}


