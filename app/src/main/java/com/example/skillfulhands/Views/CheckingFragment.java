package com.example.skillfulhands.Views;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.skillfulhands.R;
import com.example.skillfulhands.ViewModels.CheckingViewModel;
import com.example.skillfulhands.ViewModels.MyOrdersViewModel;
import com.example.skillfulhands.Views.MyOrdersFragment;
import com.example.skillfulhands.databinding.CheckingOrdersBinding;
import com.example.skillfulhands.databinding.CreateOrderBinding;

public class CheckingFragment extends Fragment {
    CheckingViewModel checkingViewModel;
    CheckingOrdersBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.checking_orders, container, false);

        checkingViewModel = new ViewModelProvider(this).get(CheckingViewModel.class);
        binding = CheckingOrdersBinding.bind(v);

        Button angryButton = binding.searchButton;
        angryButton.setOnClickListener(new View.OnClickListener() { // ДЛЯ КНОПКИ!!!
            @Override
            public void onClick(View v) {
                checkingViewModel.sendUserTel(binding.phoneNumberInput.getText().toString());

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