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
@Table(name = "appointments")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @Column(name = "start_at", nullable = false)
    @NotNull
    private LocalDateTime startAt;

    @Column(name = "end_at", nullable = false)
    @NotNull
    private LocalDateTime endAt;

    @Column(name = "appointment_status", nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    @NotNull
    private AppointmentStatus status;

    @Column(nullable = false, length = 250)
    @NotBlank
    @Size(max = 250)
    private String reason;

    @Column(name = "cancelled_at")
    private LocalDateTime cancelledAt;

    @Column(name = "cancel_reason", length = 255)
    private String cancelReason;

    public static Appointment create(
            Patient patient,
            Dentist dentist,
            LocalDateTime startAt,
            LocalDateTime endAt,
            String reason
    )
    {
            Appointment a = new Appointment();
            a.patient = patient;
            a.dentist = dentist;
            a.startAt = startAt;
            a.endAt = endAt;
            a.reason = reason;
            a.status = AppointmentStatus.SCHEDULED;
            a.cancelledAt = null;
            a.cancelReason = null;

            return a;
    }

    public void reschedule(LocalDateTime startAt, LocalDateTime endAt){
        this.startAt = startAt;
        this.endAt = endAt;
    }

    public void cancel(String cancelReason, LocalDateTime cancelledAt){
        this.status = AppointmentStatus.CANCELLED;
        this.cancelledAt = cancelledAt;
        this.cancelReason = cancelReason;
    }

}
