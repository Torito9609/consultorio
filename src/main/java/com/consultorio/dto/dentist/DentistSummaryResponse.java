package com.consultorio.dto.dentist;

import com.consultorio.domain.DentistSpecialty;
import com.consultorio.domain.DocumentType;

public record DentistSummaryResponse(
    Long id,
    String firstName,
    String lastName,
    DocumentType documentType,
    String documentNumber,
    DentistSpecialty specialty,
    String phoneNumber
) {}
