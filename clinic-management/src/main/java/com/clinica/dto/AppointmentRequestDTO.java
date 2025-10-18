package com.clinica.dto;

import java.time.LocalDateTime;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

// DTO para receber dados de agendamento pela API
public record AppointmentRequestDTO(

        @NotNull(message = "O ID do paciente é obrigatório")
        Long patientId,

        @NotNull(message = "O ID do médico é obrigatório")
        Long doctorId,

        @NotNull(message = "A data e hora do agendamento são obrigatórias")
        @Future(message = "A data do agendamento deve ser futura")
        LocalDateTime appointmentTime,

        @Size(max = 255, message = "O motivo não pode exceder 255 caracteres")
        String reason
) {
    // Usando Records do Java 16+ para concisão, mas uma classe DTO comum com Getters/Setters funciona igual.
}