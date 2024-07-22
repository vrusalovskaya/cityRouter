package com.finalproject.cityrouter.presentation;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validator {

    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    private Validator() {
    }

    public static boolean isValidCity(String passedCity) {
        try {
            City.valueOf(passedCity.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            logger.error("Failed to validate: city. Passed value: {}", passedCity);
            return false;
        }
    }

    public static boolean isValidCurrency(String passedCurrency) {
        try {
            Currency.valueOf(passedCurrency.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            logger.error("Failed to validate: currency. Passed value: {}", passedCurrency);
            return false;
        }
    }
}
