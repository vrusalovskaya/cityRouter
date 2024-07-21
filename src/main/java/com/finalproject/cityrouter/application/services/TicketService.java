package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.models.Ticket;

import java.math.BigDecimal;

public interface TicketService {
    BigDecimal buyTicket(Ticket ticket, BigDecimal travellerAmount);
}
