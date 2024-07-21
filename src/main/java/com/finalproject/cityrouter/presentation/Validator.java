package com.finalproject.cityrouter.presentation;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Currency;

public class Validator {

    private Validator() {
    }

    public static boolean isValidCity(String passedCity) {
        try {
            City.valueOf(passedCity.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static boolean isValidCurrency(String passedCurrency) {
        try {
            Currency.valueOf(passedCurrency.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
