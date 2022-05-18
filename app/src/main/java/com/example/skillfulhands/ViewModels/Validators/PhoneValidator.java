package com.example.skillfulhands.ViewModels.Validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidator implements Validator<String> {
    @Override
    public boolean isValid(String value) {
        String regex = "^((|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    @Override
    public String getDescription() {
        return "Введите телефон номера полностью!";
    }
}
