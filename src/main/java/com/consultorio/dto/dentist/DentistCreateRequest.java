package com.consultorio.dto.dentist;

import com.consultorio.domain.DentistSpecialty;
import com.consultorio.dto.person.PersonCreateRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DentistCreateRequest(
        @NotNull PersonCreateRequest person,
        @NotNull DentistSpecialty specialty,
        @NotBlank @Size(max = 50) String registration
) {}
