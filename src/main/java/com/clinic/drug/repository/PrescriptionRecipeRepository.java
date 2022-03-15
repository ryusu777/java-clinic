package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.PrescriptionRecipe;

public class PrescriptionRecipeRepository extends AbstractEntityRepository<PrescriptionRecipe> {
    public PrescriptionRecipeRepository() {
        super(PrescriptionRecipe.class);
    }

    @Override
    protected String tableName() {
        return "prescription_recipe";
    }
    
}
