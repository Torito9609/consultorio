package com.consultorio.mapper.appointment;

import com.consultorio.domain.Appointment;
import com.consultorio.domain.Dentist;
import com.consultorio.domain.Patient;
import com.consultorio.dto.appointment.*;
import com.consultorio.repository.projection.AppointmentDetailsProjection;
import com.consultorio.repository.projection.AppointmentSummaryProjection;

import java.time.LocalDateTime;

public final class AppointmentMapper {
    private AppointmentMapper(){}

    public static Appointment toEntity(AppointmentCreateRequest req, Patient patient, Dentist dentist){
        return Appointment.create(
                patient,
                dentist,
                req.startAt(),
                req.endAt(),
                req.reason()
                );
    }

    public static void applyReschedule(AppointmentRescheduleRequest req, Appointment appointment){
        appointment.reschedule(req.startAt(), req.endAt());
    }

    public static void applyCancel(AppointmentCancelRequest req, Appointment appointment, LocalDateTime now){
        appointment.cancel(req.cancelReason(), now);
    }

    public static AppointmentResponse toResponse(AppointmentDetailsProjection p){
        return new AppointmentResponse(
                p.getId(),
                p.getStartAt(),
                p.getEndAt(),
                p.getStatus(),
                p.getReason(),
                p.getCancelledAt(),
                p.getCancelReason(),
                p.getPatientId(),
                p.getPatientFirstName(),
                p.getPatientLastName(),
                p.getPatientDocumentType(),
                p.getPatientDocumentNumber(),
                p.getPatientPhoneNumber(),
                p.getDentistId(),
                p.getDentistFirstName(),
                p.getDentistLastName(),
                p.getDentistSpecialty());
    }

    public static AppointmentSummaryResponse toSummaryResponse(AppointmentSummaryProjection p){
        return new AppointmentSummaryResponse(
                p.getId(),
                p.getPatientId(),
                p.getDentistId(),
                p.getStartAt(),
                p.getEndAt(),
                p.getStatus(),
                p.getPatientFullName(),
                p.getDentistFullName()
        );
    }
}
