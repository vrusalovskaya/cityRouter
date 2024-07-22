package com.finalproject.cityrouter.application.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Ticket {
    private final City departure;
    private final City arrival;
    private final Price price;
    private final String traveller;
}