package com.finalproject.cityrouter.presentation;

import com.finalproject.cityrouter.application.models.City;
import com.finalproject.cityrouter.application.models.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Utility class for validating input values in the City Router application.
 */
public class Validator {

    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private Validator() {
    }

    /**
     * Validates if the given city name is a valid {@link City} enum value.
     *
     * @param passedCity the city name to be validated
     * @return {@code true} if the city name is valid; {@code false} otherwise
     */
    public static boolean isValidCity(String passedCity) {
        try {
            City.valueOf(passedCity.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            logger.error("Failed to validate: city. Passed value: {}", passedCity);
            return false;
        }
    }

    /**
     * Validates if the given currency name is a valid {@link Currency} enum value.
     *
     * @param passedCurrency the currency name to be validated
     * @return {@code true} if the currency name is valid; {@code false} otherwise
     */
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
