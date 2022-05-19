package com.example.skillfulhands.Models;

public enum Status {

    PROCESS("В процессе"),
    WAITING("Ожидание"),
    DONE("Получен");

    private String title;

    Status(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title;
    }
}
