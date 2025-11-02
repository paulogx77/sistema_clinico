package com.clinica.repository;

import com.clinica.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.time.LocalDate;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    List<Ticket> findByGeneratedAtBetween(LocalDate start, LocalDate end);
    Ticket findByTicketNumber(String ticketNumber);

}