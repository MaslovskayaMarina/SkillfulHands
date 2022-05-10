package com.example.skillfulhands.Views;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
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

        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding = MyOrderBinding.bind(view);

        initRecyclerView();
        //loadOrders();
    }

    private void loadOrders() {
        Collection<Order> orders = getOrders();
        myOrdersAdapter.setItems(orders);
    }

    @NonNull
    private Collection<Order> getOrders() {
        Order order1 = new Order();
        order1.setMock();
        Order order2 = new Order();
        order2.setMock();
        Order order3 = new Order();
        order3.setMock();

        return Arrays.asList(
                order1,
                order2,
                order3
        );
    }

    private void initRecyclerView() {
        //ordersRecyclerView = binding.ordersRecyclerView;
        ordersRecyclerView = getView().findViewById(R.id.orders_recycler_view);
        ordersRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myOrdersAdapter = new MyOrdersAdapter();
        ordersRecyclerView.setAdapter(myOrdersAdapter);
    }


}