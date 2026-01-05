package com.consultorio.mapper.person;

import com.consultorio.domain.Person;
import com.consultorio.dto.person.PersonCreateRequest;
import com.consultorio.dto.person.PersonUpdateRequest;

public final class PersonMapper {
    private PersonMapper(){}

    public static Person toEntity(PersonCreateRequest req){

        return Person.create(req.documentType(),
                        req.documentNumber(),
                        req.phoneNumber(),
                        req.firstName(),
                        req.lastName(),
                        req.address(),
                        req.gender(),
                        req.birthDate());
    }

    public static void apply(PersonUpdateRequest req, Person person){

    }
}
