package com.example.skillfulhands.ViewModels;

import android.os.Build;

import com.example.skillfulhands.Models.AboutOrder;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public List<AboutOrder> orders = new ArrayList<>();

    public void OrdersRepo(){
        AboutOrder aboutOrder =  new AboutOrder();
        aboutOrder.setNum(12345);
        aboutOrder.setAddress("Проспект Верндаского дом 1");
        aboutOrder.setDate("01.06.2022");
        aboutOrder.setDevice("Компьютер");
        aboutOrder.setMaster("Степан");
        aboutOrder.setNamePerson("Марина");
        aboutOrder.setNumberMaster("+79012227473");
        aboutOrder.setNumberPerson("+79012227773");
    }

    public AboutOrder getOrderByNum(int num) {
        AboutOrder result = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = orders.stream().filter(aboutOrder -> aboutOrder.getNum()==num).findFirst().get();
        }
        return result;
    }



}
