package com.example.skillfulhands.Models;

import android.os.Build;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private static Repository instance;

    public List<Order> orders = new ArrayList<>();
    public List<Promo> promos = new ArrayList<>();
    private int orderCounter = 3220000;
    private int promoCounter = 7000;
    private String serviceAddress = "Проспект Вернадского, дом 1";

    public Repository() {
        Promo noPromo = new Promo();
        noPromo.setId(promoCounter);
        noPromo.setCode("");
        noPromo.setDescription("Нет промокода");
        noPromo.setDiscountPercentage(0);
        promos.add(noPromo);
        promoCounter++;

        Promo promoMyComputer = new Promo();
        promoMyComputer.setId(promoCounter);
        promoMyComputer.setCode("MYCOMPUTER");
        promoMyComputer.setDescription("Введи промокод MYCOMPUTER и получи сскидку 5% на любой ремонт!");
        promoMyComputer.setDiscountPercentage(5);
        promos.add(promoMyComputer);
        promoCounter++;

        Promo promoNewUser = new Promo();
        promoNewUser.setId(promoCounter);
        promoNewUser.setCode("NEWUSER");
        promoNewUser.setDescription("Введи промокод NEWUSER и получи сскидку 10% на первый ремонт!");
        promoNewUser.setDiscountPercentage(10);
        promos.add(promoNewUser);
        promoCounter++;

    }

    public static Repository getInstance() {
        if (instance == null) {
            instance = new Repository();
        }
        return instance;
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
        Order result = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            result = orders.stream().filter(order -> order.getNum()==num).findFirst().get();
            return result;
        }
        return result;
    }

    public Promo getPromoByCode(String code) {
        Promo promo = null;
        for (Promo p : promos) {
            if (p.getCode().equals(code)) {
                promo = p;
            }
        }
        return promo;
    }
    public void CreateOrder(
            String clientName,
            String clientPhone,
            String device,
            String problemType,
            String problemDesc,
            String date,
            String master,
            Promo promoCode)
    {
        Order order =  new Order();
        order.setNum(Integer.toString(orderCounter));
        order.setNamePerson(clientName);
        order.setNumberPerson(clientPhone);
        order.setDevice(device);
        order.setDate(date);
        order.setProblemType(problemType);
        order.setDescription(problemDesc);
        order.setMaster(master);
        order.setNumberMaster("+79012227473");
        order.setAddress(serviceAddress);
        order.setPromo(promoCode);

        orders.add(order);

        orderCounter++;
    }

    public Order getLatest() {
        return orders.get(orders.size() - 1);
    }
}
