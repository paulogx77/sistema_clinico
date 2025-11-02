package com.clinica.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class QueueItem {
    private String ticketNumber;
    private String patientName;
    private String doctorName;
    private LocalDateTime scheduledTime;
    private String status; // WAITING, IN_PROGRESS, COMPLETED
    private int position;

    public QueueItem(String ticketNumber, String patientName, String doctorName,
                     LocalDateTime scheduledTime, String status, int position) {
        this.ticketNumber = ticketNumber;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.scheduledTime = scheduledTime;
        this.status = status;
        this.position = position;
    }
}