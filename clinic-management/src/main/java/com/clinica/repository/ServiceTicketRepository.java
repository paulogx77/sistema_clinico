package com.clinica.repository;

import java.util.Optional;
import com.clinica.model.ServiceTicket;
import com.clinica.model.enums.TicketStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ServiceTicketRepository extends JpaRepository<ServiceTicket, Long> {

    List<ServiceTicket> findByStatusOrderByCreatedAtAsc(TicketStatus status);

    Optional<ServiceTicket> findByAppointmentId(Long appointmentId);
}