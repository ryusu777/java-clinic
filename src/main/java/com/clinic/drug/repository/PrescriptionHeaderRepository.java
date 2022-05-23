package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.PrescriptionHeader;

public class PrescriptionHeaderRepository extends AbstractEntityRepository<PrescriptionHeader> {
    public PrescriptionHeaderRepository() {
        super(PrescriptionHeader.class);
    }

    @Override
    protected String tableName() {
        return "prescription_header";
    }
    
}
