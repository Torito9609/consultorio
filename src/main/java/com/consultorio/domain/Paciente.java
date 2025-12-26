package com.consultorio.domain;

import java.time.LocalDate;

public class Paciente {
    private Long id;
    private Usuario usuario;
    private LocalDate fechaNacimiento;
    private TipoDocumento tipoDocumento;
    private String numeroDocumento;
    private String direccion;
    private String genero;
    private String eps;
}
