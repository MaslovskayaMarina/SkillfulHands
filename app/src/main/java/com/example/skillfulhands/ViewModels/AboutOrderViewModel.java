package com.example.skillfulhands.ViewModels;

import androidx.databinding.Bindable;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.skillfulhands.Models.AboutOrder;

public class AboutOrderViewModel extends ViewModel {

    int num;
    private MutableLiveData<AboutOrder> aboutOrder = new MutableLiveData<>();
    private Repository repository;

    public void giveOrder(int num) {
        aboutOrder.setValue(repository.getOrderByNum(num));
    }

    public MutableLiveData<AboutOrder> getAboutOrder() {
        return aboutOrder;
    }
}
