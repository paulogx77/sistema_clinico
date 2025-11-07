package com.clinica.controller;

import com.clinica.model.QueueItem;
import com.clinica.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
// import com.clinica.service.QueueService; //adicionar isso quando for implementar a lógica real
// import org.springframework.beans.factory.annotation.Autowired; // E esta linha também

@RestController
@RequestMapping("api/queue")
public class QueueController {



    @PostMapping("/appointment/{appointmentId}/generate-ticket")
    public Ticket generateTicket(@PathVariable Long appointmentId) {
        return new Ticket();
    }

    @GetMapping("/today")
    public List<QueueItem> getTodayQueue() {
        return Collections.emptyList();
    }

    @PutMapping("/ticket/{ticketId}/call")
    public ResponseEntity<Void> callNextPatient(@PathVariable String ticketId) {
        return ResponseEntity.ok().build();
    }
}