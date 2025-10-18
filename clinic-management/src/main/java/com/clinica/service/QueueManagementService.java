package com.clinica.service;

import com.clinica.model.ServiceTicket;
import com.clinica.model.enums.TicketStatus;
import com.clinica.repository.ServiceTicketRepository;
import com.clinica.repository.AppointmentRepository;
import com.clinica.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueueManagementService {

    private final ServiceTicketRepository serviceTicketRepository;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;

    public QueueManagementService(ServiceTicketRepository serviceTicketRepository, AppointmentRepository appointmentRepository, PatientRepository patientRepository) {
        this.serviceTicketRepository = serviceTicketRepository;
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
    }




    public List<ServiceTicket> getWaitingQueue() {
        return serviceTicketRepository.findByStatusOrderByCreatedAtAsc(TicketStatus.WAITING);
    }
}