package com.clinica.service;

import com.clinica.model.Appointment;
import com.clinica.model.enums.AppointmentStatus;
import com.clinica.repository.AppointmentRepository;
import com.clinica.repository.PatientRepository;
import com.clinica.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }


    public List<Appointment> listAll() {
        return appointmentRepository.findAll();
    }
}