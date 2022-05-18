package com.example.skillfulhands.ViewModels.Validators;

public interface Validator<T> {
    boolean isValid(T value);

    String getDescription();
}
