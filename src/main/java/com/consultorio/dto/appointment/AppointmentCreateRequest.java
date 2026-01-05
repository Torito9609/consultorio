package com.consultorio.dto.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record AppointmentCreateRequest(
        @NotNull Long patientId,
        @NotNull Long dentistId,
        @NotNull LocalDateTime startAt,
        @NotNull LocalDateTime endAt,
        @NotBlank @Size(max = 250) String reason
) {}
