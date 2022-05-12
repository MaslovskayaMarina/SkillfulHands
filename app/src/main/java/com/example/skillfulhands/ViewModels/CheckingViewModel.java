package com.example.skillfulhands.ViewModels;

import androidx.lifecycle.ViewModel;

import com.example.skillfulhands.Models.Repository;

public class CheckingViewModel extends ViewModel {
    private Repository repository = Repository.getInstance();

    public void sendUserTel(String tel) {
        repository.setUserNum(tel);
    }
}
