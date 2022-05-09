package com.example.skillfulhands;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.skillfulhands.Views.MyOrdersFragment;

public class Checking extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.checking_orders, container, false);
        Button angryButton = (Button) v.findViewById(R.id.search_button);
        angryButton.setOnClickListener(new View.OnClickListener() { // ДЛЯ КНОПКИ!!!
            @Override
            public void onClick(View v) {
                Fragment someFragment = new MyOrdersFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.My2st, someFragment );
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return v;
    }
}