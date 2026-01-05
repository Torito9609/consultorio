package com.consultorio.dto.appointment;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AppointmentCancelRequest(
        @NotBlank @Size(max = 250) String cancelReason
) {}
