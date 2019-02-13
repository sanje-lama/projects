package com.example.stl.fragmenttues;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.stl.fragmenttues.fragments.MainFragment;
import com.example.stl.fragmenttues.fragments.SecondFragment;

public class MainActivity extends AppCompatActivity implements FragmentInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainFragment.newInstance(); // Yes
        // new MainFragment();  No
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_container, MainFragment.newInstance())
                .addToBackStack(null)
                .commit();


        // Communication between fragments are not recommended besides a Toast.
        //
    }

    public void showSecondFragment(String text) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, SecondFragment.newInstance(1, text))
                .addToBackStack(null)
                .commit();


    }

    @Override
    public void showThirdFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, SecondFragment.newInstance(1, ""))
                .addToBackStack(null)
                .commit();

    }
}




