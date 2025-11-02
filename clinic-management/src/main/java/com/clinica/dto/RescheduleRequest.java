package com.clinica.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class RescheduleRequest {

    private LocalDateTime newDateTime;
    private String reason;

}
