package com.consultorio.repository.projection;

import com.consultorio.domain.AppointmentStatus;
import com.consultorio.domain.DentistSpecialty;
import com.consultorio.domain.DocumentType;

import java.time.LocalDateTime;

public interface AppointmentDetailsProjection {
    Long getId();
    LocalDateTime getStartAt();
    LocalDateTime getEndAt();
    AppointmentStatus getStatus();
    String getReason();
    LocalDateTime getCancelledAt();
    String getCancelReason();
    Long getPatientId();
    String getPatientFirstName();
    String getPatientLastName();
    DocumentType getPatientDocumentType();
    String getPatientDocumentNumber();
    String getPatientPhoneNumber();
    Long getDentistId();
    String getDentistFirstName();
    String getDentistLastName();
    DentistSpecialty getDentistSpecialty();
}
