package com.consultorio.dto.patient;

import com.consultorio.domain.Eps;
import com.consultorio.dto.person.PersonResponse;

public record PatientResponse(
       Long id,
       PersonResponse person,
       Eps eps
) {}
