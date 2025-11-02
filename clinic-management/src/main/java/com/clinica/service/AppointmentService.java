package com.clinica.service;

import com.clinica.dto.AppointmentRequestDTO;
import com.clinica.dto.RescheduleRequest;
import com.clinica.model.Appointment;
import com.clinica.model.Patient;
import com.clinica.model.User;
import com.clinica.model.enums.AppointmentStatus;
import com.clinica.repository.AppointmentRepository;
import com.clinica.repository.PatientRepository;
import com.clinica.repository.UserRepository;
import com.clinica.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final UserRepository userRepository;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository,
                              PatientRepository patientRepository,
                              UserRepository userRepository) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.userRepository = userRepository;
    }

    // ✅ Já existe - manter
    public List<Appointment> listAll() {
        return appointmentRepository.findAll();
    }

    // 🔄 Método alternativo com mesmo propósito
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }

    // 📋 Buscar consulta por ID
    public Optional<Appointment> findById(Long id) {
        return appointmentRepository.findById(id);
    }

    // 👤 Buscar consultas por paciente
    public List<Appointment> findByPatientId(Long patientId) {
        return appointmentRepository.findByPatientId(patientId);
    }

    // 🩺 Buscar consultas por médico
    public List<Appointment> findByDoctorId(Long doctorId) {
        return appointmentRepository.findByDoctorId(doctorId);
    }

    // 📅 Buscar consultas por data
    public List<Appointment> findByDate(LocalDateTime date) {
        return appointmentRepository.findByAppointmentDateBetween(
                date.toLocalDate().atStartOfDay(),
                date.toLocalDate().atTime(23, 59, 59)
        );
    }

    // 🗓️ Buscar consultas de hoje
    public List<Appointment> findTodayAppointments() {
        LocalDateTime startOfDay = LocalDateTime.now().toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = LocalDateTime.now().toLocalDate().atTime(23, 59, 59);
        return appointmentRepository.findByAppointmentDateBetween(startOfDay, endOfDay);
    }

    // ➕ Agendar nova consulta
    public Appointment schedule(AppointmentRequestDTO dto) {
        // Verificar se paciente existe
        Patient patient = patientRepository.findById(dto.patientId())
                .orElseThrow(() -> new ResourceNotFoundException("Paciente não encontrado"));

        // Verificar se médico existe
        User doctor = userRepository.findById(dto.doctorId())
                .orElseThrow(() -> new ResourceNotFoundException("Médico não encontrado"));

        // Criar nova consulta
        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        appointment.setAppointmentTime(dto.appointmentTime());
        appointment.setStatus(AppointmentStatus.SCHEDULED);
        appointment.setReason(dto.reason());
        appointment.setCreatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    // ✏️ Atualizar consulta
    public Appointment update(Long id, Appointment appointmentDetails) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        appointment.setAppointmentTime(appointmentDetails.getAppointmentTime());
        appointment.setStatus(appointmentDetails.getStatus());
        appointment.setReason(appointmentDetails.getReason());
        appointment.setUpdatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    // 🔄 Remarcar consulta
    public Appointment reschedule(Long id, RescheduleRequest request) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        appointment.setAppointmentTime(request.getNewDateTime());
        appointment.setStatus(AppointmentStatus.RESCHEDULED);
        appointment.setUpdatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    // ❌ Cancelar consulta
    public Appointment cancel(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        appointment.setStatus(AppointmentStatus.CANCELED);
        appointment.setUpdatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    // ✅ Concluir consulta
    public Appointment complete(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        appointment.setStatus(AppointmentStatus.COMPLETED);
        appointment.setUpdatedAt(LocalDateTime.now());

        return appointmentRepository.save(appointment);
    }

    // 🗑️ Deletar consulta
    public void delete(Long id) {
        Appointment appointment = appointmentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Consulta não encontrada"));

        appointmentRepository.delete(appointment);
    }

    // 📊 Buscar consultas por status
    public List<Appointment> findByStatus(AppointmentStatus status) {
        return appointmentRepository.findByStatus(status);
    }

    // 🔍 Verificar disponibilidade de horário
    public boolean isTimeSlotAvailable(LocalDateTime dateTime, Long doctorId) {
        List<Appointment> existingAppointments = appointmentRepository
                .findByAppointmentDateAndDoctorId(dateTime, doctorId);

        return existingAppointments.isEmpty();
    }
}