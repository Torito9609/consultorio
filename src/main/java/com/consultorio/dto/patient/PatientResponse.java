package com.consultorio.dto.patient;

import com.consultorio.dto.person.PersonResponse;
import jakarta.validation.constraints.NotNull;

public record PatientResponse(
       Long id,
       PersonResponse person,
       String eps
) {}
