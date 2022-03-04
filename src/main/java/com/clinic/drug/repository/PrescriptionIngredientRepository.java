package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.PrescriptionIngredient;

public class PrescriptionIngredientRepository extends AbstractEntityRepository<PrescriptionIngredient> {
    protected PrescriptionIngredientRepository() {
        super(PrescriptionIngredient.class);
    }

    @Override
    protected String tableName() {
        return "prescription_ingredient";
    }
}
