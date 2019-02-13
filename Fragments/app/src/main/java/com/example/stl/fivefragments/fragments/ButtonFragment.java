package com.example.stl.fivefragments.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.stl.fivefragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ButtonFragment extends Fragment {

    private View rootView;
    private EditText editText;

    public ButtonFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_button, container, false);

        Button button01 = rootView.findViewById(R.id.button01);
        Button button02 = rootView.findViewById(R.id.button02);
        editText = rootView.findViewById(R.id.fragment_edittext);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PictureFragment pictureFragment = new PictureFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.main_container, pictureFragment).addToBackStack("picture");
                fragmentTransaction.commit();

            }
        });
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RandomFragment randomFragment = new RandomFragment();
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                String editTextContents = editText.getText().toString();
                Bundle bundle = new Bundle();
                bundle.putString("random", editTextContents);
                randomFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.main_container, randomFragment).addToBackStack("random");
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }
}