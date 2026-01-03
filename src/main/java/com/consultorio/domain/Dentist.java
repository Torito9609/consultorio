package com.consultorio.domain;

public class Dentist extends AuditableEntityBase{
    private AppUser user;
    private String specialty;
    private String registration;
    private DocumentType documentType;
    private String documentNumber;
}
