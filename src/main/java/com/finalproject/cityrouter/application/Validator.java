package com.finalproject.cityrouter.application;

import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.Ticket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class Validator {

    private static final Logger logger = LoggerFactory.getLogger(Validator.class);

    private Validator() {
    }

    public static void validateTicket(Ticket ticket) {
        if (ticket == null) {
            logger.error("Ticket is null");
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        if (ticket.getDeparture() == null) {
            logger.error("Departure city is null");
            throw new IllegalArgumentException("Departure city cannot be null");
        }

        if (ticket.getArrival() == null) {
            logger.error("Arrival city is null");
            throw new IllegalArgumentException("Arrival city cannot be null");
        }

        validatePrice(ticket.getPrice());

        if (ticket.getTraveller() == null || ticket.getTraveller().trim().isEmpty()) {
            logger.error("Traveller name is null or empty");
            throw new IllegalArgumentException("Traveller name must not be null or empty");
        }
    }

    private static void validatePrice(Price price) {
        if (price == null) {
            logger.error("Price is null");
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (price.getValue() == null) {
            logger.error("Price value is null");
            throw new IllegalArgumentException("Price value cannot be null");
        }

        if (price.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            logger.error("Price value is less than zero");
            throw new IllegalArgumentException("Price value must be greater than zero");
        }

        if (price.getCurrency() == null) {
            logger.error("Currency is null");
            throw new IllegalArgumentException("Currency cannot be null");
        }
    }
}
