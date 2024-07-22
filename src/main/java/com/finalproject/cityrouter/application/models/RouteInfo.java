package com.finalproject.cityrouter.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class RouteInfo {
    private final Integer segmentsQuantity;
    private final Price price;
}
