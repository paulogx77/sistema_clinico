package com.clinica.controller;

import com.clinica.model.Doctor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    @GetMapping
    public List<Doctor> getAllDoctors() { }

    @GetMapping("/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable Long id) { }

    @PostMapping
    public Doctor createDoctor(@RequestBody Doctor doctor) { }

    @PutMapping("/{id}")
    public ResponseEntity<Doctor> updateDoctor(@PathVariable Long id, @RequestBody Doctor doctorDetails) { }

    @GetMapping("/specialty/{specialty}")
    public List<Doctor> getDoctorsBySpecialty(@PathVariable String specialty) { }

    @GetMapping("/available")
    public List<Doctor> getAvailableDoctors(@RequestParam String date, @RequestParam String time) { }
}