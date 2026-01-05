package com.consultorio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "patients")

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Patient extends AuditableEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Size(max = 30)
    private Eps eps;
}
