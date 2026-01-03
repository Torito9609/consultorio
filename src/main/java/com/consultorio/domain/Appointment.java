package com.consultorio.domain;

import java.time.LocalDateTime;

public class Appointment {
    private Long id;
    private Patient patient;
    private Dentist dentist;
    private LocalDateTime dateTime;
    private int minutesDuration;
    private AppointmentStatus appointmentStatus;
    private String reason;
}
