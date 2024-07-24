package com.finalproject.cityrouter.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * Represents the price in the City Router system.
 */
@Getter
@AllArgsConstructor
@ToString
public class Price {
    private final BigDecimal value;
    private final Currency currency;
}
