package com.finalproject.cityrouter.presentation.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TicketResponseDto {
    private String result;
    private BigDecimal change;
    private BigDecimal lackOf;
    private String currency;

    private TicketResponseDto(String result, BigDecimal change, BigDecimal lackOf, String currency) {
        this.result = result;
        this.change = change;
        this.lackOf = lackOf;
        this.currency = currency;
    }

    public static TicketResponseDto createError(String message) {
        return new TicketResponseDto(message, null, null, null);
    }

    public static TicketResponseDto createSuccess(BigDecimal change, String currency) {
        return new TicketResponseDto("success", change, null, currency);
    }

    public static TicketResponseDto createFailure(BigDecimal lackOf, String currency) {
        return new TicketResponseDto("failure", null, lackOf, currency);
    }
}
