package com.consultorio.dto.appointment;

import com.consultorio.domain.AppointmentStatus;
import com.consultorio.domain.DentistSpecialty;
import com.consultorio.domain.DocumentType;

import java.time.LocalDateTime;

public record AppointmentResponse(
    Long id,
    LocalDateTime startAt,
    LocalDateTime endAt,
    AppointmentStatus status,
    String reason,
    LocalDateTime cancelledAt,
    String cancelReason,
    Long patientId,
    String patientFirstName,
    String patientLastName,
    DocumentType patientDocumentType,
    String patientDocumentNumber,
    String patientPhoneNumber,
    Long dentistId,
    String dentistFirstName,
    String dentistLastName,
    DentistSpecialty dentistSpecialty
) {}
