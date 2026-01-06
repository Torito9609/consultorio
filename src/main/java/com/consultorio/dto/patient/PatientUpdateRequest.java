package com.consultorio.dto.patient;

import com.consultorio.domain.Eps;
import com.consultorio.dto.person.PersonUpdateRequest;


public record PatientUpdateRequest(
        PersonUpdateRequest person,
        Eps eps
) {}
