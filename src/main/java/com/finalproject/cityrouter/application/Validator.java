package com.finalproject.cityrouter.application;

import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.Ticket;

import java.math.BigDecimal;

public class Validator {

    private Validator() {
    }

    public static void validateTicket(Ticket ticket) {
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        if (ticket.getDeparture() == null) {
            throw new IllegalArgumentException("Departure city cannot be null");
        }
        
        if (ticket.getArrival() == null) {
            throw new IllegalArgumentException("Arrival city cannot be null");
        }

        validatePrice(ticket.getPrice());

        if (ticket.getTraveller() == null || ticket.getTraveller().trim().isEmpty()) {
            throw new IllegalArgumentException("Traveller name must not be null or empty");
        }
    }

    private static void validatePrice(Price price) {
        if (price == null) {
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (price.getValue() == null) {
            throw new IllegalArgumentException("Price value cannot be null");
        }

        if (price.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price value must be greater than zero");
        }

        if (price.getCurrency() == null) {
            throw new IllegalArgumentException("Currency cannot be null");
        }
    }
}
