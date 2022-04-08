package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
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
