package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.Medicine;

public class MedicineRepository extends AbstractEntityRepository<Medicine> {
    public MedicineRepository() {
        super(Medicine.class);
    }

    @Override
    protected String tableName() {
        return "medicine";
    }
}
