package com.finalproject.cityrouter.presentation.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.finalproject.cityrouter.application.models.Currency;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RouteInfoDto {
    private Integer segments;
    private BigDecimal price;
    private Currency currency;
    private String error;

    public RouteInfoDto(int segments, BigDecimal price, Currency currency) {
        this.segments = segments;
        this.price = price;
        this.currency = currency;
    }

    public RouteInfoDto(String error) {
        this.error = error;
    }
}
