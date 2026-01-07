package com.consultorio.repository.projection;

import com.consultorio.domain.AppointmentStatus;

import java.time.LocalDateTime;

public interface AppointmentSummaryProjection {
    Long getId();
    Long getPatientId();
    Long getDentistId();
    LocalDateTime getStartAt();
    LocalDateTime getEndAt();
    AppointmentStatus getStatus();
    String getPatientFullName();
    String getDentistFullName();
}
