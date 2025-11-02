package com.clinica.controller;

import com.clinica.model.Consultation;
import com.clinica.model.MedicalRecord;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/medical-records")
public class MedicalRecordController {

    @GetMapping("/patient/{patientId}")
    public MedicalRecord getMedicalRecordByPatient(@PathVariable Long patientId) { }

    @PostMapping("/patient/{patientId}")
    public MedicalRecord createOrUpdateMedicalRecord(@PathVariable Long patientId, @RequestBody MedicalRecord record) { }

    @PostMapping("/patient/{patientId}/consultation")
    public Consultation addConsultation(@PathVariable Long patientId, @RequestBody Consultation consultation) { }

}
