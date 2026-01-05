package com.consultorio.dto.patient;

import com.consultorio.domain.DocumentType;

public record PatientSummaryResponse(
    Long id,
    String firstName,
    String lastName,
    DocumentType documentType,
    String documentNumber,
    String phoneNumber
) {}
