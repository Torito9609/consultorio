package com.consultorio.domain;

import java.time.LocalDateTime;

public class Cita {
    private Long id;
    private Paciente paciente;
    private Odontologo odontologo;
    private LocalDateTime fechaHora;
    private int duracionMinutos;
    private EstadoCita estadoCita;
    private String motivo;
}
