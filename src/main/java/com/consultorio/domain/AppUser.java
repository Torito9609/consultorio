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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;

    @Column(nullable = false, length = 254)
    @NotBlank @Email @Size(max = 254)
    private String email;

    @Column(nullable = false, length = 255)
    @NotBlank
    private String passwordHash;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private UserStatus userStatus;
}
