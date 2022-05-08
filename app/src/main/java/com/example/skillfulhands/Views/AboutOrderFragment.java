package com.example.skillfulhands.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillfulhands.R;
import com.example.skillfulhands.ViewModels.AboutOrderViewModel;
import com.example.skillfulhands.databinding.InformationAboutBinding;

import androidx.lifecycle.ViewModelProvider;

public class AboutOrderFragment extends Fragment {
    private AboutOrderViewModel order;
    private InformationAboutBinding binding;

    public AboutOrderFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        order = new ViewModelProvider(this).get(AboutOrderViewModel.class);
        //order.giveOrder("76744");
        order.setRecievedOrder();
        return inflater.inflate(R.layout.information_about, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = InformationAboutBinding.bind(view);

        binding.customer.setText(order.getAboutOrder().getNamePerson());
        binding.numberorder.setText(order.getAboutOrder().getNum());
        binding.namedevice.setText(order.getAboutOrder().getDevice());
        binding.dateOfBringing.setText(order.getAboutOrder().getDate());
        binding.address.setText(order.getAboutOrder().getAddress());
        binding.customer.setText(order.getAboutOrder().getNamePerson() + '\n' + order.getAboutOrder().getNumberPerson());
        binding.master.setText(order.getAboutOrder().getMaster() + "\n" + order.getAboutOrder().getNumberMaster());

    }



}