package com.clinica.repository;

import com.clinica.model.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByMedicalRecordId(Long medicalRecordId);
}