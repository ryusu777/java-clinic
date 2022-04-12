package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.DosageForm;
import com.clinic.drug.repository.DosageFormRepository;

import javafx.scene.layout.GridPane;

public class DosageFormController extends AbstractCrudController<DosageForm, DosageFormRepository> {
    public DosageFormController() {
        super(DosageForm.class, DosageFormRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, DosageForm entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Name", entity.nameProperty())
            .addPickField(
                "Category",
                entity.dosageFormCategoryIdProperty(),
                new DosageFormCategoryController(),
                "getName"
            )
            .addButton(generateSubmitButton("Submit", entity));
    }
}
