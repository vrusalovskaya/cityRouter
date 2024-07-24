package com.finalproject.cityrouter.application;

import com.finalproject.cityrouter.application.models.Price;
import com.finalproject.cityrouter.application.models.Ticket;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;

/**
 * Utility class for validating {@link Ticket} and {@link Price} objects.
 * <p>
 * This class provides static methods for validating tickets and prices to ensure they meet the required constraints.
 * It is designed to be used across the application wherever validation of these objects is needed.
 * </p>
 */
@Slf4j
public class TicketValidator {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private TicketValidator() {
    }

    /**
     * Validates the specified {@code Ticket} object.
     *
     * @param ticket the {@code Ticket} object to be validated
     * @throws IllegalArgumentException if the ticket or any of its fields are invalid
     */
    public static void validateTicket(Ticket ticket) {
        if (ticket == null) {
            log.error("Ticket is null");
            throw new IllegalArgumentException("Ticket cannot be null");
        }

        if (ticket.getDeparture() == null) {
            log.error("Departure city is null");
            throw new IllegalArgumentException("Departure city cannot be null");
        }

        if (ticket.getArrival() == null) {
            log.error("Arrival city is null");
            throw new IllegalArgumentException("Arrival city cannot be null");
        }

        validatePrice(ticket.getPrice());

        if (ticket.getTraveller() == null || ticket.getTraveller().trim().isEmpty()) {
            log.error("Traveller name is null or empty");
            throw new IllegalArgumentException("Traveller name must not be null or empty");
        }
    }

    /**
     * Validates the specified {@code Price} object.
     * <p>
     * This method performs the following checks:
     * <ul>
     *     <li>Ensures the price is not null.</li>
     *     <li>Checks that the price value is not null and is greater than zero.</li>
     *     <li>Ensures the currency is not null.</li>
     * </ul>
     * If any of these conditions are not met, an {@link IllegalArgumentException} is thrown.
     * </p>
     *
     * @param price the {@code Price} object to be validated
     * @throws IllegalArgumentException if the price or any of its fields are invalid
     */
    private static void validatePrice(Price price) {
        if (price == null) {
            log.error("Price is null");
            throw new IllegalArgumentException("Price cannot be null");
        }

        if (price.getValue() == null) {
            log.error("Price value is null");
            throw new IllegalArgumentException("Price value cannot be null");
        }

        if (price.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            log.error("Price value is less than zero");
            throw new IllegalArgumentException("Price value must be greater than zero");
        }

        if (price.getCurrency() == null) {
            log.error("Currency is null");
            throw new IllegalArgumentException("Currency cannot be null");
        }
    }
}
