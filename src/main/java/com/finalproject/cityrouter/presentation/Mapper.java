package com.finalproject.cityrouter.presentation;

import com.finalproject.cityrouter.application.models.*;
import com.finalproject.cityrouter.presentation.dtos.RouteInfoDto;
import com.finalproject.cityrouter.presentation.dtos.SaveTicketRequestDto;

public class Mapper {

    private Mapper() {
    }

    public static RouteInfoDto toDto(RouteInfo routeInfo) {
        return new RouteInfoDto(
                routeInfo.getSegmentsQuantity(),
                routeInfo.getPrice().getValue(),
                routeInfo.getPrice().getCurrency());
    }

    public static Ticket toModel(SaveTicketRequestDto ticketDto) {
        return new Ticket(
                City.valueOf(ticketDto.getArrival().toUpperCase()),
                City.valueOf(ticketDto.getDeparture().toUpperCase()),
                new Price(ticketDto.getPrice(), Currency.valueOf(ticketDto.getCurrency().toUpperCase())),
                ticketDto.getTraveller()
        );
    }
}
