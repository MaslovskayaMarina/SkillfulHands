package com.example.skillfulhands;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.skillfulhands.Views.AboutOrderFragment;

public class Succesfully extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.successfully_created, container, false);
        Button angryButton = (Button) v.findViewById(R.id.angry_btn3);
        angryButton.setOnClickListener(new View.OnClickListener() { // ДЛЯ КНОПКИ!!!
            public void onClick(View v) {
                Fragment someFragment = new AboutOrderFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.My2st, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return v;
    }
}