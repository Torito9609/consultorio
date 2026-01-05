package com.consultorio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(
        name = "persons",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_person_document",
                        columnNames = {"document_type", "document_number"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Person extends AuditableEntityBase{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "document_type", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private DocumentType documentType;

    @Column(name = "document_number", nullable = false, length = 20)
    @NotBlank
    @Size(max = 20)
    private String documentNumber;

    @Column(name = "phone_number", nullable = false, length = 20)
    @NotBlank @Size(max = 20)
    private String phoneNumber;

    @Column(name = "first_name", nullable = false, length = 60)
    @NotBlank @Size(max = 60)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 60)
    @NotBlank @Size(max = 60)
    private String lastName;

    @Column(nullable = false, length = 150)
    @Size(max = 150)
    @NotBlank
    private String address;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private Gender gender;

    @Column(name = "birth_date", nullable = false)
    @NotNull
    private LocalDate birthDate;

    public static Person create(DocumentType documentType,
                               String documentNumber,
                               String phoneNumber,
                               String firstName,
                               String lastName,
                               String address,
                               Gender gender,
                               LocalDate birthDate){
        Person p =  new Person();
        p.documentType = documentType;
        p.documentNumber = documentNumber.trim();
        p.phoneNumber = phoneNumber.trim();
        p.firstName = firstName.trim();
        p.lastName = lastName.trim();
        p.address = address.trim();
        p.gender = gender;
        p.birthDate = birthDate;

        return p;
    }
}
