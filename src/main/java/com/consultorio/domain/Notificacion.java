package com.consultorio.domain;

import java.time.LocalDateTime;

public class Notificacion {
    private Long id;
    private Usuario destinatario;
    private String mensaje;
    private TipoNotificacion tipo;
    private LocalDateTime fechaEnvio;
}
