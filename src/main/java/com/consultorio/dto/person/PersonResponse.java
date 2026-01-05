package com.consultorio.dto.person;

import com.consultorio.domain.DocumentType;
import com.consultorio.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

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
