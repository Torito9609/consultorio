package com.consultorio.dto.person;

import com.consultorio.domain.DocumentType;
import com.consultorio.domain.Gender;

import java.time.LocalDate;

public record PersonResponse(
        Long id,
        DocumentType documentType,
        String documentNumber,
        String phoneNumber,
        String firstName,
        String lastName,
        String address,
        Gender gender,
        LocalDate birthDate
) {}
