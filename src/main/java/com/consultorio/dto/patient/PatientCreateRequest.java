package com.consultorio.dto.patient;

import com.consultorio.domain.Eps;
import com.consultorio.dto.person.PersonCreateRequest;
import jakarta.validation.constraints.NotNull;

public record PatientCreateRequest(
    PersonCreateRequest person,
    Eps eps
) {}
