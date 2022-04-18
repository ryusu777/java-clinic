package com.clinic.receptionist.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.receptionist.domain.Doctor;

public class DoctorRepository extends AbstractEntityRepository<Doctor>{
    public DoctorRepository() {
        super(Doctor.class);
    }

    @Override
    protected String tableName() {
        return "doctor";
    }
    
}
