package com.consultorio.domain;

public class Dentist extends AuditableEntityBase{
    private Long id;
    private User user;
    private String specialty;
    private String registration;
    private DocumentType documentType;
    private String documentNumber;
}
