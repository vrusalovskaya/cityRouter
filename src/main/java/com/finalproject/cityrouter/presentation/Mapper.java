package com.finalproject.cityrouter.presentation;

import com.finalproject.cityrouter.application.models.*;
import com.finalproject.cityrouter.presentation.dtos.RouteInfoDto;
import com.finalproject.cityrouter.presentation.dtos.SaveTicketRequestDto;

/**
 * Utility class for mapping between different object types in the City Router application.
 */
public class Mapper {

    /**
     * Private constructor to prevent instantiation of the utility class.
     */
    private Mapper() {
    }

    /**
     * Converts a {@link RouteInfo} object to a {@link RouteInfoDto} object.
     *
     * @param routeInfo the {@code RouteInfo} object to be converted
     * @return a {@code RouteInfoDto} object representing the same route information
     */
    public static RouteInfoDto toDto(RouteInfo routeInfo) {
        return new RouteInfoDto(
                routeInfo.getSegmentsQuantity(),
                routeInfo.getPrice().getValue(),
                routeInfo.getPrice().getCurrency());
    }

    /**
     * Converts a {@link SaveTicketRequestDto} object to a {@link Ticket} object.
     *
     * @param ticketDto the {@code SaveTicketRequestDto} object to be converted
     * @return a {@code Ticket} object representing the same ticket information
     */
    public static Ticket toModel(SaveTicketRequestDto ticketDto) {
        return new Ticket(
                City.valueOf(ticketDto.getArrival().toUpperCase()),
                City.valueOf(ticketDto.getDeparture().toUpperCase()),
                new Price(ticketDto.getPrice(), Currency.valueOf(ticketDto.getCurrency().toUpperCase())),
                ticketDto.getTraveller()
        );
    }
}
