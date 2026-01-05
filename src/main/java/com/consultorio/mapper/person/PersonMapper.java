package com.consultorio.mapper.person;

import com.consultorio.domain.Person;
import com.consultorio.dto.person.PersonCreateRequest;
import com.consultorio.dto.person.PersonResponse;
import com.consultorio.dto.person.PersonUpdateRequest;

import java.util.Objects;

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
        if(req.phoneNumber() != null) person.changePhoneNumber(req.phoneNumber());
        if(req.firstName() != null) person.changeFirstName(req.firstName());
        if(req.lastName() != null) person.changeLastName(req.lastName());
        if(req.address() != null) person.changeAddress(req.address());
        if(req.gender() != null) person.changeGender(req.gender());
        if(req.birthDate() != null) person.changeBirthDate(req.birthDate());
    }

    public static PersonResponse toResponse(Person p){

        return
    }
}
