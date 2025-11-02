package com.clinica.controller;

import com.clinica.model.QueueItem;
import com.clinica.model.Ticket;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/queue")
public class QueueController {

    @PostMapping("/appointment/{appointmentId}/generate-ticket")
    public Ticket generateTicket(@PathVariable Long appointmentId) { }

    @GetMapping("/today")
    public List<QueueItem> getTodayQueue() { }

    @PutMapping("/ticket/{ticketId}/call")
    public ResponseEntity<Void> callNextPatient(@PathVariable String ticketId) { }
}
