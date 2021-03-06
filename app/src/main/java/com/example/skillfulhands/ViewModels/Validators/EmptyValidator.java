package com.example.skillfulhands.ViewModels.Validators;

import android.text.TextUtils;

public class EmptyValidator implements Validator<String>{
    @Override
    public boolean isValid(String value) {
        return !TextUtils.isEmpty(value);
    }

    @Override
    public String getDescription() {
        return "Поля не должно быть пустым!";
    }
}
