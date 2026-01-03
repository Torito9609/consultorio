package com.consultorio.domain;

import jakarta.persistence.Entity;

@Entity
public class User extends AuditableEntityBase{
    private Long id;
    private String name;
    private String lastname;
    private String mail;
    private String phone;
    private String passwordHash;
    private Role role;
    private UserStatus userStatus;
}
