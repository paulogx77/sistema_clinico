package com.clinica.controller;

import com.clinica.dto.DashboardStats;
import com.clinica.model.Appointment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Collections;

@RestController
public class DashboardController {

    @GetMapping("/stats")
    public DashboardStats getDashboardStats() {
        return new DashboardStats();
    }

    @GetMapping("/appointments/today")
    public List<Appointment> getTodayAppointments() {
        return Collections.emptyList();
    }
}