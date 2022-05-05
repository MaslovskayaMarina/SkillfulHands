package com.example.skillfulhands.Models;

import android.os.Build;

import com.example.skillfulhands.Models.Order;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    public List<Order> orders = new ArrayList<>();
    private int orderCounter = 3220000;

    public Repository() {
        OrdersRepo();
    }

    public void OrdersRepo(){
        Order order =  new Order();
        order.setNum("76744");
        order.setAddress("Проспект Верндаского дом 1");
        order.setDate("01.06.2022");
        order.setDevice("Компьютер");
        order.setMaster("Степан");
        order.setNamePerson("Марина");
        order.setNumberMaster("+79012227473");
        order.setNumberPerson("+79012227773");
        orders.add(order);
    }

    public Order getOrderByNum(String num) {
        OrdersRepo();
        Order result = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = orders.stream().filter(order -> order.getNum()==num).findFirst().get();
            return result;
        }
        return result;
    }
}
