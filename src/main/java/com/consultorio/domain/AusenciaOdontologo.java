package com.consultorio.domain;

import java.time.LocalDate;

public class AusenciaOdontologo {
    private Long id;
    private Odontologo odontologo;
    private String motivo;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
}
