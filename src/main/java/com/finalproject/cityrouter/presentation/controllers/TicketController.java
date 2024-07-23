package com.finalproject.cityrouter.presentation.controllers;

import com.finalproject.cityrouter.application.exceptions.NotEnoughMoneyException;
import com.finalproject.cityrouter.application.services.TicketService;
import com.finalproject.cityrouter.presentation.Mapper;
import com.finalproject.cityrouter.presentation.dtos.SaveTicketRequestDto;
import com.finalproject.cityrouter.presentation.dtos.TicketResponseDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

import static com.finalproject.cityrouter.presentation.Validator.isValidCity;
import static com.finalproject.cityrouter.presentation.Validator.isValidCurrency;

/**
 * REST controller for handling ticket-related requests in the City Router application.
 */
@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class TicketController {

    private final TicketService ticketService;

    /**
     * Handles the HTTP POST request to save a ticket purchase request.
     *
     * @param ticketToSave the ticket details to be saved
     * @return a {@link ResponseEntity} containing the ticket purchase result or an error message
     */
    @PostMapping("/tickets")
    public ResponseEntity<TicketResponseDto> saveTicket(@RequestBody SaveTicketRequestDto ticketToSave) {

        if (!isValidCity(ticketToSave.getDeparture()) ||
                !isValidCity(ticketToSave.getArrival()) ||
                !isValidCurrency(ticketToSave.getCurrency())) {
            return ResponseEntity.badRequest().body(TicketResponseDto.createError("Invalid arguments"));
        }

        try {
            BigDecimal change = ticketService.buyTicket(Mapper.toModel(ticketToSave), ticketToSave.getTravellerAmount());
            log.info("Ticket was successfully bought");
            return ResponseEntity.ok(TicketResponseDto.createSuccess(change, ticketToSave.getCurrency()));
        } catch (NotEnoughMoneyException e) {
            log.info("Unable to buy ticket: not enough money");
            return ResponseEntity.badRequest().body(TicketResponseDto.createFailure(e.getAmountLacked(), ticketToSave.getCurrency()));
        }
    }
}

