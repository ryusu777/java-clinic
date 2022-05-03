package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.MedicineRequest;

public class MedicineRequestRepository extends AbstractEntityRepository<MedicineRequest> {
    public MedicineRequestRepository() {
        super(MedicineRequest.class);
    }

    @Override
    protected String tableName() {
        return "medicine_request";
    }
}
