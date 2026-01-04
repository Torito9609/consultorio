package com.consultorio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(
        name = "dentists",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_dentists_document",
                        columnNames = {"document_type", "document_number"}
                )
        }
)
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Dentist extends AuditableEntityBase{
    @Id
    private Long id;

    @MapsId
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private AppUser user;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private DentistSpecialty specialty;

    @Column(nullable = false, length = 30)
    @NotBlank
    @Size(max = 30)
    private String registration;

    @Column(name = "document_type", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private DocumentType documentType;

    @Column(name = "document_number", nullable = false, length = 20)
    @NotBlank
    @Size(max = 20)
    private String documentNumber;
}
