package com.example.skillfulhands.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.Models.Repository;

public class AboutOrderViewModel extends ViewModel {

    private Order order = new Order();
    private Repository repository = Repository.getInstance();

    public void giveOrder(String num) {
        order = repository.getOrderByNum(num);
    }

    public Order getAboutOrder() {
        return order;
    }

    public void setRecievedOrder() {
        order = repository.getLatest();
    }
}
