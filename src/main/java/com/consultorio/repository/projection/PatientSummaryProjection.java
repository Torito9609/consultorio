package com.consultorio.repository.projection;

import com.consultorio.domain.DocumentType;

public interface PatientSummaryProjection {
    Long getId();
    String getFirstName();
    String getLastName();
    DocumentType documentType();
    String getDocumentNumber();
    String getPhoneNumber();
}
