package com.consultorio.dto.dentist;

import com.consultorio.domain.DentistSpecialty;
import com.consultorio.dto.person.PersonResponse;

public record DentistResponse(
        Long id,
        PersonResponse person,
        DentistSpecialty specialty,
        String registration
) {}
