package com.clinica.controller;

import com.clinica.model.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Collections;
import java.util.Optional;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return Collections.emptyList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) {
        return ResponseEntity.of(Optional.empty());
        // Alternativamente: return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        return doctor;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) {
        return ResponseEntity.ok(doctorDetails);
    }

    @GetMapping("/specialty/{specialty}")
    public List<Doctor> getDoctorsBySpecialty(@PathVariable String specialty) {
        return Collections.emptyList(); // Retorna uma lista vazia de Doutores por especialidade
    }

    @GetMapping("/available")
    public List<Doctor> getAvailableDoctors(@RequestParam String date, @RequestParam String time) {
        return Collections.emptyList(); // Retorna uma lista vazia de Doutores disponíveis
    }
}