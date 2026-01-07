package com.consultorio.repository;

import com.consultorio.domain.Appointment;
import com.consultorio.repository.projection.AppointmentDetailsProjection;
import com.consultorio.repository.projection.AppointmentSummaryProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

    @Query("""
        select
            a.id as id,
            a.startAt as startAt,
            a.endAt as endAt,
            a.status as status,
            a.reason as reason,
            a.cancelledAt as cancelledAt,
            a.cancelReason as cancelReason,

            pat.id as patientId,
            pp.firstName as patientFirstName,
            pp.lastName as patientLastName,
            pp.documentType as patientDocumentType,
            pp.documentNumber as patientDocumentNumber,
            pp.phoneNumber as patientPhoneNumber,

            den.id as dentistId,
            dp.firstName as dentistFirstName,
            dp.lastName as dentistLastName,
            den.specialty as dentistSpecialty
        from Appointment a
        join a.patient pat
        join pat.person pp
        join a.dentist den
        join den.person dp
        where a.id = :id
    """)
    Optional<AppointmentDetailsProjection> findDetailsById(@Param("id") Long id);

    @Query("""
        select
            a.id as id,
            pat.id as patientId,
            den.id as dentistId,
            a.startAt as startAt,
            a.endAt as endAt,
            a.status as status,
            concat(pp.firstName, ' ', pp.lastName) as patientFullName,
            concat(dp.firstName, ' ', dp.lastName) as dentistFullName
        from Appointment a
        join a.patient pat
        join pat.person pp
        join a.dentist den
        join den.person dp
        where a.startAt >= :from and a.startAt < :to
        order by a.startAt asc
    """)
    List<AppointmentSummaryProjection> findSummaryBetween(
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );

    @Query("""
        select
            a.id as id,
            pat.id as patientId,
            den.id as dentistId,
            a.startAt as startAt,
            a.endAt as endAt,
            a.status as status,
            concat(pp.firstName, ' ', pp.lastName) as patientFullName,
            concat(dp.firstName, ' ', dp.lastName) as dentistFullName
        from Appointment a
        join a.patient pat
        join pat.person pp
        join a.dentist den
        join den.person dp
        where den.id = :dentistId
          and a.startAt >= :from and a.startAt < :to
        order by a.startAt asc
    """)
    List<AppointmentSummaryProjection> findSummaryByDentistBetween(
            @Param("dentistId") Long dentistId,
            @Param("from") LocalDateTime from,
            @Param("to") LocalDateTime to
    );

    @Query("""
        select (count(a) > 0)
        from Appointment a
        where a.dentist.id = :dentistId
          and a.status <> com.consultorio.domain.AppointmentStatus.CANCELLED
          and a.startAt < :endAt
          and a.endAt > :startAt
    """)
    boolean existsOverlap(
            @Param("dentistId") Long dentistId,
            @Param("startAt") LocalDateTime startAt,
            @Param("endAt") LocalDateTime endAt
    );

    @Query("""
        select (count(a) > 0)
        from Appointment a
        where a.id <> :appointmentId
          and a.dentist.id = :dentistId
          and a.status <> com.consultorio.domain.AppointmentStatus.CANCELLED
          and a.startAt < :endAt
          and a.endAt > :startAt
    """)
    boolean existsOverlapExcluding(
            @Param("appointmentId") Long appointmentId,
            @Param("dentistId") Long dentistId,
            @Param("startAt") LocalDateTime startAt,
            @Param("endAt") LocalDateTime endAt
    );
}
