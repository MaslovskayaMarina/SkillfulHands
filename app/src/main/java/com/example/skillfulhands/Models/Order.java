package com.example.skillfulhands.Models;

public class Order {
    private String num;
    private String device, date, address, namePerson, numberPerson, master, numberMaster;
    private String problemType, description;
    private int currentPrice;
    private Promo promo;

    public void setNum(String num) {
        this.num = num;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    public void setNumberPerson(String numberPerson) {
        this.numberPerson = numberPerson;
    }

    public void setMaster(String master) {
        this.master = master;
    }

    public void setNumberMaster(String numberMaster) {
        this.numberMaster = numberMaster;
    }

    public void setProblemType(String problemType) {
        this.problemType = problemType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public String getNum() {
        return num;
    }

    public String getDevice() {
        return device;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public String getNumberPerson() {
        return numberPerson;
    }

    public String getMaster() {
        return master;
    }

    public String getNumberMaster() {
        return numberMaster;
    }

    public String getProblemType() {
        return problemType;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public Promo getPromo() {
        return promo;
    }
}
