package com.clinica.controller;

import com.clinica.dto.AppointmentRequestDTO;
import com.clinica.model.Appointment;
import com.clinica.service.AppointmentService;
import com.clinica.service.QueueManagementService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final QueueManagementService queueService; // Pode ser útil para gerar o ticket após o agendamento

    @Autowired
    public AppointmentController(AppointmentService appointmentService, QueueManagementService queueService) {
        this.appointmentService = appointmentService;
        this.queueService = queueService;
    }


    // Objetivo: Agendar uma nova consulta
    @PostMapping
    public ResponseEntity<Appointment> schedule(
            @RequestBody @Valid AppointmentRequestDTO dto,
            UriComponentsBuilder uriBuilder
    ) {
        // Lógica de agendamento seria chamada aqui:
        // Appointment appointment = appointmentService.schedule(dto);

        // Simulação de resposta (a lógica virá depois)
        Appointment appointment = new Appointment();

        // Retorna 201 Created com a URI do novo recurso
        URI uri = uriBuilder.path("/appointments/{id}").buildAndExpand(appointment.getId()).toUri();
        return ResponseEntity.created(uri).body(appointment);
    }


    @DeleteMapping("/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id) {
        return ResponseEntity.noContent().build();
    }

}