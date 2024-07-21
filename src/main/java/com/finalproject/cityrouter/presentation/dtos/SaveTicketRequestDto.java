package com.finalproject.cityrouter.presentation.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class SaveTicketRequestDto {
    private String departure;
    private String arrival;
    private int segments;
    private BigDecimal price;
    private String currency;
    private BigDecimal travellerAmount;
    private String traveller;
}
