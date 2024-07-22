package com.finalproject.cityrouter.application;

import com.finalproject.cityrouter.application.models.Ticket;
import com.finalproject.cityrouter.persistence.entities.TicketEntity;

/**
 * Utility class for mapping between {@link Ticket} and {@link TicketEntity} objects.
 * <p>
 * This class provides static methods for converting a {@code Ticket} object to a {@code TicketEntity}
 * object. It is designed to be used for data transfer and persistence operations.
 * </p>
 */
public class TicketMapper {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private TicketMapper() {
    }

    /**
     * Converts a {@code Ticket} object to a {@code TicketEntity} object.
     * <p>
     * This method maps the fields of the {@code Ticket} object to corresponding fields in the {@code TicketEntity}
     * object.
     * </p>
     *
     * @param ticket the {@code Ticket} object to be converted
     * @return the {@code TicketEntity} object representing the same data as the {@code Ticket}
     */
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
