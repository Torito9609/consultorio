package com.consultorio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "app_user",
        uniqueConstraints = {
        @UniqueConstraint(name = "uk_app_user_email", columnNames = "email")
        }
    )
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AppUser extends AuditableEntityBase{
    @Column(nullable = false, length = 60)
    @NotBlank @Size(max = 60)
    private String name;

    @Column(nullable = false, length = 60)
    @NotBlank @Size(max = 60)
    private String lastName;

    @Column(nullable = false, length = 254)
    @NotBlank @Email @Size(max = 254)
    private String email;

    @Column(nullable = false, length = 20, unique = false)
    @NotBlank @Size(max = 20)
    private String phone;

    @Column(nullable = false, length = 255)
    @NotNull
    private String passwordHash;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserStatus userStatus;

    private void updateEmail(String newEmail){
        this.email = newEmail;
    }

    private void updatePhoneNumber(String newPhoneNumber){
        this.phone = newPhoneNumber;
    }

    private void updatepasswordHash(String newPasswordHash){
        this.passwordHash = newPasswordHash;
    }

    private void updateFirstName(String newFirstName){
        this. name = newFirstName;
    }

    private void updateLastName(String newLastName){
        this.lastName = newLastName;
    }
}
