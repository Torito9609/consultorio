package com.consultorio.mapper.patient;

import com.consultorio.domain.Patient;
import com.consultorio.domain.Person;
import com.consultorio.dto.patient.PatientCreateRequest;
import com.consultorio.dto.patient.PatientResponse;
import com.consultorio.dto.patient.PatientSummaryResponse;
import com.consultorio.dto.patient.PatientUpdateRequest;
import com.consultorio.mapper.person.PersonMapper;
import com.consultorio.projection.PatientSummaryProjection;

public final class PatientMapper {
    private PatientMapper(){}

    public static Patient toEntity(PatientCreateRequest req, Person person){
        return Patient.create(person, req.eps());
    }

    public static void apply(PatientUpdateRequest req, Patient patient){
        if(req.eps() != null) patient.changeEps(req.eps());
    }

    public PatientResponse toResponse(Patient patient){
        return new PatientResponse(
                    patient.getId(),
                    PersonMapper.toResponse(patient.getPerson()),
                    patient.getEps()
        );
    }

    public PatientSummaryResponse toSummaryResponse(PatientSummaryProjection p){
        return new PatientSummaryResponse(
                    p.getId(),
                    p.getFirstName(),
                    p.getLastName(),
                    p.documentType(),
                    p.getDocumentNumber(),
                    p.getPhoneNumber());
    }
}
