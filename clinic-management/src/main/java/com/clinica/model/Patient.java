package com.clinica.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String cpf; // [cite: 10]

    private LocalDate birthDate; // [cite: 11]
    private String gender;
    private String phone;
    private String email;
    private String address;

    private String allergies; // [cite: 12]
    private String medicalHistory; // [cite: 12]

    private LocalDateTime createdAt = LocalDateTime.now(); // [cite: 12]
    private LocalDateTime updatedAt = LocalDateTime.now(); // [cite: 12]

    // Relacionamentos:
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>(); // List<Appointment> [cite: 12]

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ServiceTicket> serviceTickets = new ArrayList<>(); // List<ServiceTicket> [cite: 12]

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalRecord> medicalRecords = new ArrayList<>(); // List<MedicalRecord> [cite: 12]

    // Construtor padrão (necessário para JPA)
    public Patient() {}
}