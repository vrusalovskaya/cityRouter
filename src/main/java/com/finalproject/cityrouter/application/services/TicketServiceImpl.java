package com.finalproject.cityrouter.application.services;

import com.finalproject.cityrouter.application.TicketMapper;
import com.finalproject.cityrouter.application.exceptions.NotEnoughMoneyException;
import com.finalproject.cityrouter.application.models.Ticket;
import com.finalproject.cityrouter.persistence.repositories.TicketRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import static com.finalproject.cityrouter.application.Validator.validateTicket;

@Service
@AllArgsConstructor
class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    @Override
    public BigDecimal buyTicket(Ticket ticket, BigDecimal travellerAmount) {
        validateTicket(ticket);
        BigDecimal moneyDifference = travellerAmount.subtract(ticket.getPrice().getValue());

        if (moneyDifference.compareTo(BigDecimal.ZERO) < 0) {
            throw new NotEnoughMoneyException(moneyDifference.abs());
        }

        ticketRepository.save(TicketMapper.toEntity(ticket));
        return moneyDifference;
    }
}
