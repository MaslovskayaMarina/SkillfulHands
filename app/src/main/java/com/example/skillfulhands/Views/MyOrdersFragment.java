package com.example.skillfulhands.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.R;
import com.example.skillfulhands.ViewModels.MakeOrderViewModel;
import com.example.skillfulhands.ViewModels.MyOrdersViewModel;
import com.example.skillfulhands.databinding.CreateOrderBinding;
import com.example.skillfulhands.databinding.MyOrderBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class MyOrdersFragment extends Fragment {
    private MyOrdersViewModel orders;
    private MyOrderBinding binding;
    private RecyclerView ordersRecyclerView;
    private MyOrdersAdapter myOrdersAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.my_order, container, false);
        orders = new ViewModelProvider(this).get(MyOrdersViewModel.class);

        orders = new ViewModelProvider(this).get(MyOrdersViewModel.class);
        final Observer<ArrayList<Order>> nameObserver = new Observer<ArrayList<Order>>() {
            @Override
            public void onChanged(@Nullable final ArrayList<Order> order) {
                myOrdersAdapter = new MyOrdersAdapter(order,requireContext());
                ordersRecyclerView.setAdapter(myOrdersAdapter);
            }
        };
        ordersRecyclerView = v.findViewById(R.id.orders_recycler_view);

        orders.getUserOrders(v).observe(getViewLifecycleOwner(), nameObserver);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getContext(),1);
        ordersRecyclerView.setLayoutManager(gridLayoutManager);

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }


}