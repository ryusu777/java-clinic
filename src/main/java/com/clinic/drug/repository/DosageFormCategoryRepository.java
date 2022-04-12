package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.DosageFormCategory;

public class DosageFormCategoryRepository extends AbstractEntityRepository<DosageFormCategory> {
    public DosageFormCategoryRepository() {
        super(DosageFormCategory.class);
    }

    @Override
    protected String tableName() {
        return "dosage_form_category";
    }
}
