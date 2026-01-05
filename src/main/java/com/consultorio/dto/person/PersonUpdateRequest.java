package com.consultorio.dto.person;

import com.consultorio.domain.Gender;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonUpdateRequest(
        @Size(max = 20) String phoneNumber,

        @Size(max = 60) String firstName,

        @Size(max = 60) String lastName,

        @Size(max = 150) String address,

        LocalDate birthDate,

        Gender gender
) {}
