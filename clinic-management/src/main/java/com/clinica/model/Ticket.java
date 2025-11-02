package com.clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticketNumber;
    private LocalDateTime generatedAt;
    private String status;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;
}