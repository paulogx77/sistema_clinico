package com.clinica.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DashboardStats {

    private long totalPatients;
    private long totalAppointmentsToday;
    private long pendingAppointments;
    private long availableDoctors;

}
