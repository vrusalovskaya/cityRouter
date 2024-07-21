package com.finalproject.cityrouter.application;

import com.finalproject.cityrouter.application.models.Ticket;
import com.finalproject.cityrouter.persistence.entities.TicketEntity;

public class TicketMapper {

    private TicketMapper() {
    }

    public static TicketEntity toEntity(Ticket ticket) {
        TicketEntity ticketEntity = new TicketEntity();
        ticketEntity.setArrival(ticket.getArrival().toString());
        ticketEntity.setDeparture(ticket.getDeparture().toString());
        ticketEntity.setPrice(ticket.getPrice().getValue());
        ticketEntity.setCurrency(ticket.getPrice().getCurrency().toString());
        ticketEntity.setTraveller(ticket.getTraveller());
        return ticketEntity;
    }
}
