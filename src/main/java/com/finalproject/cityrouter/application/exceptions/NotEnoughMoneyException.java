package com.finalproject.cityrouter.application.exceptions;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Exception thrown when a traveler does not have enough money to purchase a ticket.
 */

@Getter
public class NotEnoughMoneyException extends RuntimeException {
    private final BigDecimal amountLacked;

    /**
     * Constructs a new {@code NotEnoughMoneyException} with the specified amount lacked.
     *
     * @param amountLacked the amount of money that is lacking to complete the transaction.
     */
    public NotEnoughMoneyException(BigDecimal amountLacked) {
        super("Not enough money. Amount lacked: " + amountLacked);
        this.amountLacked = amountLacked;
    }
}

