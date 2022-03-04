package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.DosageForm;

public class DosageFormRepository extends AbstractEntityRepository<DosageForm> {
    protected DosageFormRepository() {
        super(DosageForm.class);
    }

    @Override
    protected String tableName() {
        return "dosage_form";
    }
}
