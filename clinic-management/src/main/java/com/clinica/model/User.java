    package com.clinica.model;

    import com.clinica.model.enums.UserRole;
    import jakarta.persistence.*;
    import lombok.Getter;
    import lombok.Setter;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;

    @Getter
    @Setter
    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        private String name;
        private String email;
        private String password; // [cite: 7]

        @Enumerated(EnumType.STRING)
        private UserRole role; // ADMIN, RECEPTIONIST, DOCTOR [cite: 7]

        private boolean active;

        // Campos específicos para DOCTOR
        private String specialty; // [cite: 8]
        private String crm; // [cite: 8]

        private LocalDateTime createdAt = LocalDateTime.now(); // [cite: 9]
        private LocalDateTime updatedAt = LocalDateTime.now(); // [cite: 9]

        // Relacionamentos:
        @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<Appointment> appointments = new ArrayList<>(); // List<Appointment> [cite: 9]

        @OneToMany(mappedBy = "calledByDoctor", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<ServiceTicket> calledTickets = new ArrayList<>(); // List<ServiceTicket> [cite: 9]

        @OneToMany(mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
        private List<MedicalRecord> medicalRecords = new ArrayList<>(); // List<MedicalRecord> [cite: 9]

        // Construtor padrão (necessário para JPA)
        public User() {}
    }