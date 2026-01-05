package com.consultorio.dto.appointment;

import com.consultorio.domain.AppointmentStatus;

import java.time.LocalDateTime;

public record AppointmentSummaryResponse(
       Long id,
       Long patientId,
       Long dentistId,
       LocalDateTime startAt,
       LocalDateTime endAt,
       AppointmentStatus status,
       String patientFullName,
       String dentistFullName
) {}
