package com.clinic.receptionist.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.receptionist.domain.Patient;

public class PatientRepository extends AbstractEntityRepository<Patient>{

    public PatientRepository() {
        super(Patient.class);
    }

    @Override
    protected String tableName() {
        return "patient";
    }
    
}
