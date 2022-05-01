package com.example.skillfulhands.Views;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.skillfulhands.R;
import com.example.skillfulhands.Models.AboutOrder;
import com.example.skillfulhands.ViewModels.AboutOrderViewModel;
import com.example.skillfulhands.ViewModels.Repository;
import com.example.skillfulhands.databinding.InformationAboutBinding;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;



public class AboutOrderFragment extends Fragment {
    private InformationAboutBinding binding;

    public AboutOrderFragment() {
        // required
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = InformationAboutBinding.inflate(inflater, container, false);

        binding.numberorder.setText("666666");
        binding.namedevice.setText("Nokia 3310");
        binding.dateOfBringing.setText("27.02.2002");
        binding.address.setText("Улица пушкина, дома колотушкина");
        binding.customer.setText("Беркунов Еблан Игоревич");
        binding.master.setText("Дима дебил луканенко");

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}