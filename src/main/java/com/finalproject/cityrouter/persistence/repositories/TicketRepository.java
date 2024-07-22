package com.finalproject.cityrouter.persistence.repositories;

import com.finalproject.cityrouter.persistence.entities.TicketEntity;
import org.springframework.data.repository.ListCrudRepository;

/**
 * Repository interface for accessing and managing {@link TicketEntity} entities.
 */
public interface TicketRepository extends ListCrudRepository<TicketEntity, Integer> {
}
