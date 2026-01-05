package com.consultorio.dto.person;


import com.consultorio.domain.DocumentType;
import com.consultorio.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonCreateRequest(
    @NotNull DocumentType documentType,
    @NotBlank @Size(max = 20) String documentNumber,
    @NotBlank @Size(max = 20) String phoneNumber,
    @NotBlank @Size(max = 60) String firstName,
    @NotBlank @Size(max = 60) String lastName,
    @NotBlank @Size(max = 150) String address,
    @NotNull Gender gender,
    @NotNull LocalDate birthDate
) {}
