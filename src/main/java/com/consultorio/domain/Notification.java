package com.consultorio.domain;

import java.time.LocalDateTime;

public class Notification {
    private Long id;
    private User receiver;
    private String message;
    private NotificationType notificationType;
    private LocalDateTime dispatchDate;
}
