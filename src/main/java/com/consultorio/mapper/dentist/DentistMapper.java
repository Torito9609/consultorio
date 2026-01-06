package com.consultorio.mapper.dentist;

import com.consultorio.domain.Dentist;
import com.consultorio.domain.Person;
import com.consultorio.dto.dentist.DentistCreateRequest;
import com.consultorio.dto.dentist.DentistResponse;
import com.consultorio.dto.dentist.DentistSummaryResponse;
import com.consultorio.dto.dentist.DentistUpdateRequest;
import com.consultorio.mapper.person.PersonMapper;
import com.consultorio.projection.DentistSummaryResponseProjection;

public final class DentistMapper {
    private DentistMapper(){}

    public static Dentist toEntity(DentistCreateRequest req, Person person){
        return Dentist.create(person, req.specialty(), req.registration());
    }

    public static void apply(DentistUpdateRequest req, Dentist dentist){
        if(req.specialty() != null) dentist.changeSpecialty(req.specialty());
    }

    public DentistResponse toResponse(Dentist dentist){
        return new DentistResponse(
                dentist.getId(),
                PersonMapper.toResponse(dentist.getPerson()),
                dentist.getSpecialty()
        );
    }

    public DentistSummaryResponse toSummaryResponse(DentistSummaryResponseProjection d){
        return new DentistSummaryResponse(
                d.getId(),
                d.getFirstName(),
                d.getLastName(),
                d.documentType(),
                d.documentNumber(),
                d.getSpecialty(),
                d.getPhoneNumber());
    }
}
