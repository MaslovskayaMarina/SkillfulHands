package com.example.skillfulhands.ViewModels;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.Models.Repository;

import java.util.ArrayList;

public class MyOrdersViewModel extends ViewModel {
    private Repository repository = Repository.getInstance();
    private MutableLiveData<ArrayList<Order>> currentOrder;

    public MutableLiveData<ArrayList<Order>> getUserOrders(View v) {
        if (currentOrder == null) {
            currentOrder = new MutableLiveData<ArrayList<Order>>();
        }
        currentOrder.setValue(repository.getOrdersByUser());
        return currentOrder;
    }
}
