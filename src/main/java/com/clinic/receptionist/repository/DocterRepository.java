package com.clinic.receptionist.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.receptionist.domain.Doctor;

public class DocterRepository extends AbstractEntityRepository<Doctor>{
    public DocterRepository() {
        super(Doctor.class);
    }

    @Override
    protected String tableName() {
        return "doctor";
    }
    
}
