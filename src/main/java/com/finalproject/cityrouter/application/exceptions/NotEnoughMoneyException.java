package com.finalproject.cityrouter.application.exceptions;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class NotEnoughMoneyException extends RuntimeException {
    private final BigDecimal amountLacked;

    public NotEnoughMoneyException(BigDecimal amountLacked) {
        super("Not enough money. Amount lacked: " + amountLacked);
        this.amountLacked = amountLacked;
    }
}

