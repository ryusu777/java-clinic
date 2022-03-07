package com.clinic.doctor.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.doctor.domain.MedicalRecord;

public class MedicalRecordRepository extends AbstractEntityRepository<MedicalRecord> {
    public MedicalRecordRepository() {
        super(MedicalRecord.class);
    }

    @Override
    protected String tableName() {
        return "medical_record";
    }
}
