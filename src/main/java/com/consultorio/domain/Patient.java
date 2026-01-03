package com.consultorio.domain;

import java.time.LocalDate;

public class Patient extends AuditableEntityBase{
    private Long id;
    private User user;
    private LocalDate birthDate;
    private DocumentType documentType;
    private String documentNumber;
    private String address;
    private String gender;
    private String eps;
}
