package com.finalproject.cityrouter.presentation.controllers;

import com.finalproject.cityrouter.application.exceptions.NotEnoughMoneyException;
import com.finalproject.cityrouter.application.services.TicketService;
import com.finalproject.cityrouter.presentation.Mapper;
import com.finalproject.cityrouter.presentation.dtos.SaveTicketRequestDto;
import com.finalproject.cityrouter.presentation.dtos.TicketResponseDto;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static com.finalproject.cityrouter.presentation.Validator.isValidCity;
import static com.finalproject.cityrouter.presentation.Validator.isValidCurrency;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class TicketController {

    private static final Logger logger = LoggerFactory.getLogger(TicketController.class);

    private final TicketService ticketService;

    @PostMapping("/tickets")
    public ResponseEntity<TicketResponseDto> saveTicket(@RequestBody SaveTicketRequestDto ticketToSave) {

        if (!isValidCity(ticketToSave.getDeparture()) ||
                !isValidCity(ticketToSave.getArrival()) ||
                !isValidCurrency(ticketToSave.getCurrency())) {
            return ResponseEntity.badRequest().body(TicketResponseDto.createError("Invalid arguments"));
        }

        try {
            BigDecimal change = ticketService.buyTicket(Mapper.toModel(ticketToSave), ticketToSave.getTravellerAmount());
            logger.info("Ticket was successfully bought");
            return ResponseEntity.ok(TicketResponseDto.createSuccess(change, ticketToSave.getCurrency()));
        } catch (NotEnoughMoneyException e) {
            logger.info("Unable to buy ticket: not enough money");
            return ResponseEntity.badRequest().body(TicketResponseDto.createFailure(e.getAmountLacked(), ticketToSave.getCurrency()));
        }
    }
}

