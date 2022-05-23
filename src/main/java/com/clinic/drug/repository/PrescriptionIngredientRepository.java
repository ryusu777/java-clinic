package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.PrescriptionIngredient;

public class PrescriptionIngredientRepository extends AbstractEntityRepository<PrescriptionIngredient> {
    public PrescriptionIngredientRepository() {
        super(PrescriptionIngredient.class);
    }

    @Override
    protected String tableName() {
        return "prescription_ingredient";
    }
}
