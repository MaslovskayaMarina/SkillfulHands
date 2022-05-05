package com.example.skillfulhands.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.skillfulhands.Models.Order;
import com.example.skillfulhands.Models.Repository;

public class MakeOrderViewModel extends ViewModel {

    private Order order = new Order();
    private Repository repository = Repository.getInstance();

    public void makeOrder(
            String clientName,
            String clientPhone,
            String device,
            String date,
            String master
    ) {
        repository.CreateOrder(clientName, clientPhone, device, date, master);
    }
}
