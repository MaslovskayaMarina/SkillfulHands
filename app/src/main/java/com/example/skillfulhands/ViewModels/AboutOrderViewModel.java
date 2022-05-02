package com.example.skillfulhands.ViewModels;

import androidx.databinding.Bindable;
import androidx.databinding.BaseObservable;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.text.TextUtils;
import android.util.Patterns;

import com.example.skillfulhands.Models.AboutOrder;

public class AboutOrderViewModel extends ViewModel {

    private AboutOrder aboutOrder = new AboutOrder();
    private Repository repository = new Repository();

    public void giveOrder(String num) {
        aboutOrder = repository.getOrderByNum(num);
    }

    public AboutOrder getAboutOrder() {
        return aboutOrder;
    }
}
