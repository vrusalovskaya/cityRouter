package com.finalproject.cityrouter.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class RouteInfo {
    private final Integer segmentsQuantity;
    private final Price price;
}
