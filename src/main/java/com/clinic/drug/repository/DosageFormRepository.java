package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.DosageForm;

public class DosageFormRepository extends AbstractEntityRepository<DosageForm> {
    public DosageFormRepository() {
        super(DosageForm.class);
    }

    @Override
    protected String tableName() {
        return "dosage_form";
    }
}
