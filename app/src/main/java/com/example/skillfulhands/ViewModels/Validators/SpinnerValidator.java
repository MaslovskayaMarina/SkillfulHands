package com.example.skillfulhands.ViewModels.Validators;

public class SpinnerValidator implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        return value.equals("Выбрать...") ? false : true;
    }

    @Override
    public String getDescription() {
        return "Вы должны выбрать один из вариантов";
    }
}
