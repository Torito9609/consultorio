package com.consultorio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dentists")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dentist extends AuditableEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "person_id", nullable = false, unique = true)
    private Person person;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private DentistSpecialty specialty;

    @Column(nullable = false, length = 50, unique = true)
    @NotBlank
    @Size(max = 50)
    private String registration;

    public static Dentist create(Person person, DentistSpecialty specialty, String registration){
        Dentist d = new Dentist();
        d.person = person;
        d.specialty = specialty;
        d.registration = registration;
        return d;
    }

    public void changeSpecialty(DentistSpecialty specialty){
        this.specialty = specialty;
    }
}
