package com.clinica.controller;

import com.clinica.model.Consultation;
import com.clinica.model.MedicalRecord;
import org.springframework.web.bind.annotation.*;

// import com.clinica.service.MedicalRecordService; // Descomente quando for implementar a lógica real
// import org.springframework.beans.factory.annotation.Autowired; // e esta linha
// import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @GetMapping("/patient/{patientId}")
    public MedicalRecord getMedicalRecordByPatient(@PathVariable Long patientId) {
        return new MedicalRecord();
    }

    @PostMapping("/patient/{patientId}")
    public MedicalRecord createOrUpdateMedicalRecord(@PathVariable Long patientId, @RequestBody MedicalRecord record) {
        return record;
    }

    @PostMapping("/patient/{patientId}/consultation")
    public Consultation addConsultation(@PathVariable Long patientId, @RequestBody Consultation consultation) {
        return consultation;
    }
}