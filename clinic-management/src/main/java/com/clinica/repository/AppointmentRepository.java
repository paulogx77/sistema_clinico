package com.clinica.repository;

import com.clinica.model.Appointment;
import com.clinica.model.enums.AppointmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    // Métodos básicos
    List<Appointment> findByPatientId(Long patientId);
    List<Appointment> findByDoctorId(Long doctorId);
    List<Appointment> findByStatus(AppointmentStatus status);

    // Consultas por data
    List<Appointment> findByAppointmentDateBetween(LocalDateTime start, LocalDateTime end);

    // Verificar horário disponível
    @Query("SELECT a FROM Appointment a WHERE a.appointmentDate = :dateTime AND a.doctor.id = :doctorId")
    List<Appointment> findByAppointmentDateAndDoctorId(@Param("dateTime") LocalDateTime dateTime,
                                                       @Param("doctorId") Long doctorId);

    // Consultas de hoje para um médico específico
    @Query("SELECT a FROM Appointment a WHERE a.doctor.id = :doctorId AND DATE(a.appointmentDate) = CURRENT_DATE")
    List<Appointment> findTodayAppointmentsByDoctor(@Param("doctorId") Long doctorId);
}