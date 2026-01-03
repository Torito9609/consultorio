package com.consultorio.domain;

import java.time.LocalDate;

public class DentistAbsentees {
    private Long id;
    private Dentist dentist;
    private String reason;
    private LocalDate startDate;
    private LocalDate endDate;
}
