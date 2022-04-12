package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.DosageFormCategory;
import com.clinic.drug.repository.DosageFormCategoryRepository;

import javafx.scene.layout.GridPane;

public class DosageFormCategoryController extends AbstractCrudController<DosageFormCategory, DosageFormCategoryRepository> {
    public DosageFormCategoryController() {
        super(DosageFormCategory.class, DosageFormCategoryRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, DosageFormCategory entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Category Name", entity.nameProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
