package com.example.stl.fragmenttues.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.stl.fragmenttues.FragmentInterface;
import com.example.stl.fragmenttues.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    private FragmentInterface fragmentInterface;




    public static MainFragment newInstance() {
    return new MainFragment();

}

    //
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof FragmentInterface) {
            fragmentInterface = ((FragmentInterface)context);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);



    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

     final EditText editText = view.findViewById(R.id.edit_text);
     final Button button1 = view.findViewById(R.id.button01);

     button1.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             String text = editText.getText().toString();
             Toast.makeText(v.getContext(), text,Toast.LENGTH_SHORT).show();


             fragmentInterface.showSecondFragment(text);

             fragmentInterface.showThirdFragment();


         }
     });
    }



    }

