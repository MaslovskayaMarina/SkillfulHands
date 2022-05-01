package com.example.skillfulhands.Views;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.BindingAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.skillfulhands.R;
import com.example.skillfulhands.databinding.InformationAboutBinding;
import com.example.skillfulhands.Models.AboutOrder;
import com.example.skillfulhands.ViewModels.AboutOrderViewModel;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;



public class AboutOrderFragment extends Fragment {

    private AboutOrderViewModel aboutOrder;
    private InformationAboutBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        aboutOrder = new ViewModelProvider(this).get(AboutOrderViewModel.class);
        aboutOrder.giveOrder(12345);

        return inflater.inflate(R.layout.information_about, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = InformationAboutBinding.bind(view);
        aboutOrder.getAboutOrder().observe(getViewLifecycleOwner(), aboutOrder1 -> {
            binding.numberorder.setText(aboutOrder1.getNum());
        });
    }
}