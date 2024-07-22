package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.TicketMapper;
import com.finalproject.cityrouter.application.exceptions.NotEnoughMoneyException;
import com.finalproject.cityrouter.application.models.Ticket;
import com.finalproject.cityrouter.persistence.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.finalproject.cityrouter.application.TicketValidator.validateTicket;

/**
 * Implementation of the {@link TicketService} that handles the purchase of tickets.
 */
@Service
@AllArgsConstructor
class TicketServiceImpl implements TicketService {

    private static final Logger logger = LoggerFactory.getLogger(TicketServiceImpl.class);

    private final TicketRepository ticketRepository;

    @Override
    public BigDecimal buyTicket(Ticket ticket, BigDecimal travellerAmount) {

        logger.info("buyTicket method is called. Details: {}, {}", ticket, travellerAmount);

        validateTicket(ticket);
        BigDecimal moneyDifference = travellerAmount.subtract(ticket.getPrice().getValue());

        if (moneyDifference.compareTo(BigDecimal.ZERO) < 0) {
            logger.error("Not enough money");
            throw new NotEnoughMoneyException(moneyDifference.abs());
        }

        ticketRepository.save(TicketMapper.toEntity(ticket));
        return moneyDifference;
    }
}
