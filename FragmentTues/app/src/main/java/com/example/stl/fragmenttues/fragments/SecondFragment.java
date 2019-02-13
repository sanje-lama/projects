package com.example.stl.fragmenttues.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.stl.fragmenttues.FragmentInterface;
import com.example.stl.fragmenttues.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    public static final String FRAGMENT_CHOICE_KEY = "Choice_key";
    public static final String FRAGMENT_STRING_KEY = "String";






    public static SecondFragment newInstance(int choice, String string) {
        SecondFragment fragment = new SecondFragment();
        Bundle arguments = new Bundle();
        arguments.putInt(FRAGMENT_CHOICE_KEY, choice);
        arguments.putString(FRAGMENT_STRING_KEY,string );
        fragment.setArguments(arguments);
        return fragment;
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments()!=null && getArguments().containsKey(FRAGMENT_CHOICE_KEY)
                                 && getArguments().containsKey(FRAGMENT_STRING_KEY)) {
            int choice = getArguments().getInt(FRAGMENT_CHOICE_KEY);
            String string = getArguments().getString(FRAGMENT_STRING_KEY);
            Toast.makeText(getContext(), "done",Toast.LENGTH_LONG).show();
            Toast.makeText(getContext(), "done",Toast.LENGTH_LONG).show();

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

}
