package com.consultorio.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "dentist_absences")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DentistAbsence extends AuditableEntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private AbsenceType absenceType;

    @Column(nullable = false, length = 150)
    @NotBlank
    @Size(max = 150)
    private String reasonDetail;

    @Column(name = "start_at", nullable = false)
    @NotNull
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = false)
    @NotNull
    private LocalDateTime endAt;
}
