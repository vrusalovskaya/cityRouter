package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.exceptions.NotEnoughMoneyException;
import com.finalproject.cityrouter.application.models.Ticket;

import java.math.BigDecimal;

/**
 * Service interface for handling ticket purchases in the City Router system.
 */
public interface TicketService {
    /**
     * Processes the purchase of a ticket for a traveler.
     *
     * @param ticket the ticket to be purchased
     * @param travellerAmount the amount of money the traveler has
     * @return the remaining amount of money after purchasing the ticket
     * @throws NotEnoughMoneyException if the traveler does not have enough money to purchase the ticket
     */
    BigDecimal buyTicket(Ticket ticket, BigDecimal travellerAmount);
}
