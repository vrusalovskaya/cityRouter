package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.TicketMapper;
import com.finalproject.cityrouter.application.exceptions.NotEnoughMoneyException;
import com.finalproject.cityrouter.application.models.Ticket;
import com.finalproject.cityrouter.persistence.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.finalproject.cityrouter.application.TicketValidator.validateTicket;

/**
 * Implementation of the {@link TicketService} that handles the purchase of tickets.
 */
@Service
@AllArgsConstructor
@Slf4j
class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public BigDecimal buyTicket(Ticket ticket, BigDecimal travellerAmount) {

        log.info("buyTicket method is called. Details: {}, {}", ticket, travellerAmount);

        validateTicket(ticket);
        BigDecimal moneyDifference = travellerAmount.subtract(ticket.getPrice().getValue());

        if (moneyDifference.compareTo(BigDecimal.ZERO) < 0) {
            log.error("Not enough money");
            throw new NotEnoughMoneyException(moneyDifference.abs());
        }

        ticketRepository.save(TicketMapper.toEntity(ticket));
        return moneyDifference;
    }
}
