package com.finalproject.cityrouter.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents information about a route in the City Router system.
 */
@Getter
@AllArgsConstructor
@ToString
public class RouteInfo {
    private final Integer segmentsQuantity;
    private final Price price;
}
