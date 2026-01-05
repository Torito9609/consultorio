package com.consultorio.dto.dentist;

import com.consultorio.domain.DentistSpecialty;
import com.consultorio.dto.person.PersonUpdateRequest;
import jakarta.validation.constraints.Size;

public record DentistUpdateRequest(
        PersonUpdateRequest person,
        DentistSpecialty specialty,
        @Size(max = 50) String registration
) {}
