package com.example.skillfulhands.Models;

public class Promo {
    private int id;
    private int discountPercentage;
    private String code, description;

    public void setId(int id) {
        this.id = id;
    }

    public void setDiscountPercentage(int discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getDiscountPercentage() {
        return discountPercentage;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
