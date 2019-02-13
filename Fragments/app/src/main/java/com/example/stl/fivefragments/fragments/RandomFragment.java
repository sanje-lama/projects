package com.example.stl.fivefragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.stl.fivefragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class RandomFragment extends Fragment {

    private View rootView;
    private TextView textview;

    public RandomFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_random, container, false);
        textview = rootView.findViewById(R.id.random_textview);

        Bundle bundle = getArguments();
        String textFromEditText = bundle.getString("random", "");
        textview.setText(textFromEditText);

        return rootView;
    }

}
