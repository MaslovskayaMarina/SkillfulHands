package com.example.skillfulhands.Models;

public class Order {
    private String num;
    private String device, date, address, namePerson, numberPerson, master, numberMaster;
    private String problemType, description;
    private int currentPrice;
    private Promo promo;
    private Status status;

    public Order() {
        this.status = Status.PROCESS;
    }

    public Order(String num,
                 String device,
                 String date,
                 String address,
                 String namePerson,
                 String numberPerson,
                 String master,
                 String numberMaster,
                 String problemType,
                 String description) {
        this.num = num;
        this.device = device;
        this.date = date;
        this.address = address;
        this.namePerson = namePerson;
        this.numberPerson = numberPerson;
        this.master = master;
        this.numberMaster = numberMaster;
        this.problemType = problemType;
        this.description = description;
        this.currentPrice = currentPrice;
        this.promo = promo;
        this.status = Status.PROCESS;
    }

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

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMock() {
        this.num = "228";
        this.device = "Wileyfox AMG 63";
        this.date = "27.02.2002";
        this.address = "Вавилова 5";
        this.namePerson = "Юрий Дудь";
        this.numberPerson = "+79774470661";
        this.master = "Гена Букин";
        this.numberMaster = "+378887776655";
        this.problemType = "Матрица экрана";
        this.description = "Сломалась значит у меня матрица на мобиле..";
        this.currentPrice = 8000;
        this.promo = new Promo();
        this.promo.setCode("HESOYAM");
        this.promo.setId(666);
        this.promo.setDescription("Ну вот значит тестовая акция на 15 процентов");
        this.promo.setDiscountPercentage(15);
        this.status = Status.DONE;
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

    public Status getStatus() {
        return status;
    }
}
