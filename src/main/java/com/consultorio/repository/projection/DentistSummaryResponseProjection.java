package com.consultorio.repository.projection;

import com.consultorio.domain.DentistSpecialty;
import com.consultorio.domain.DocumentType;

public interface DentistSummaryResponseProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    DocumentType documentType();
    String documentNumber();
    DentistSpecialty getSpecialty();
    String getPhoneNumber();
}
