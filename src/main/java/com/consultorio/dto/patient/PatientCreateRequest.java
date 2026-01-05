package com.consultorio.dto.patient;

import com.consultorio.dto.person.PersonCreateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PatientCreateRequest(
    @NotNull PersonCreateRequest person,
    @Size(max = 30) String eps
) {}
