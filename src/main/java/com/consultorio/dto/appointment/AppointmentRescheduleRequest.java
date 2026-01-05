package com.consultorio.dto.appointment;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record AppointmentRescheduleRequest(
        @NotNull LocalDateTime startAt,
        @NotNull LocalDateTime endAt
) {}
