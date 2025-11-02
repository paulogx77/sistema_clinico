package com.clinica.controller;

import com.clinica.dto.DashboardStats;
import com.clinica.model.Appointment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DashboardController {

    @GetMapping("/stats")
    public DashboardStats getDashboardStats() { }

    @GetMapping("/appointments/today")
    public List<Appointment> getTodayAppointments() { }
}
