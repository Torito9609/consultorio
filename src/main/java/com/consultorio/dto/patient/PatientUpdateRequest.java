package com.consultorio.dto.patient;

import com.consultorio.dto.person.PersonUpdateRequest;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PatientUpdateRequest(
        PersonUpdateRequest person,
        @Size(max = 30) String eps
) {}
