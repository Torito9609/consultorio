package com.consultorio.repository;

import com.consultorio.domain.*;
import com.consultorio.repository.projection.AppointmentDetailsProjection;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AppointmentRepositoryTest {
    @Autowired
    private TestEntityManager em;

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Test
    void findDetailsById_returnsFlattenedFields(){
        Person patientPerson = Person.create(
                DocumentType.CC,
                "1000000001",
                "3105487896",
                "Kevin",
                "Toro",
                "calle 1 # 2 -3",
                Gender.MALE,
                LocalDate.of(2000,1,1)
        );
        em.persist(patientPerson);

        Patient patient = Patient.create(patientPerson, Eps.SANITAS);
        em.persist(patient);

        Person dentistPerson = Person.create(
                DocumentType.CC,
                "20000000002",
                "3124578965",
                "Rafael",
                "Casas",
                "Calle 1 # 38d 05",
                Gender.MALE,
                LocalDate.of(1996,9,9)
        );
        em.persist(dentistPerson);

        Dentist dentist = Dentist.create(dentistPerson, DentistSpecialty.GENERAL,"ABC12345DEF");
        em.persist(dentist);

        Appointment appointment = Appointment.create(
                patient,
                dentist,
                LocalDateTime.of(2026,1,7,10,0),
                LocalDateTime.of(2026,1,7,10,20),
                "Limpieza general"
        );
        em.persist(appointment);

        em.flush();
        em.clear();

        AppointmentDetailsProjection p = appointmentRepository.findDetailsById(appointment.getId()).orElseThrow();

        assertThat(p.getId()).isNotNull();
        assertThat(p.getStartAt()).isEqualTo(LocalDateTime.of(2026,1,7,10,0));
        assertThat(p.getEndAt()).isEqualTo(LocalDateTime.of(2026,1,7,10,20));
        assertThat(p.getReason()).isEqualTo("Limpieza general");

        assertThat(p.getStatus()).isEqualTo(AppointmentStatus.SCHEDULED);

        assertThat(p.getPatientId()).isNotNull();
        assertThat(p.getPatientFirstName()).isEqualTo("Kevin");
        assertThat(p.getPatientLastName()).isEqualTo("Toro");
        assertThat(p.getPatientDocumentType()).isEqualTo(DocumentType.CC);
        assertThat(p.getPatientDocumentNumber()).isEqualTo("100000001");
        assertThat(p.getPatientPhoneNumber()).isEqualTo("3001112222");

        assertThat(p.getPatientFirstName()).isEqualTo("Kevin");
        assertThat(p.getPatientLastName()).isEqualTo("Toro");
        assertThat(p.getPatientDocumentType()).isEqualTo(DocumentType.CC);
        assertThat(p.getPatientDocumentNumber()).isEqualTo("100000001");
        assertThat(p.getPatientPhoneNumber()).isEqualTo("3001112222");
    }
}
