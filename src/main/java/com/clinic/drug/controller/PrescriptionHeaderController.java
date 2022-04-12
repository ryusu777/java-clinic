package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PrescriptionHeader;
import com.clinic.drug.repository.PrescriptionHeaderRepository;

import javafx.scene.layout.GridPane;

public class PrescriptionHeaderController extends AbstractCrudController<PrescriptionHeader, PrescriptionHeaderRepository> {
    public PrescriptionHeaderController() {
        super(PrescriptionHeader.class, PrescriptionHeaderRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, PrescriptionHeader entity) {
        new GridFormBuilder(formGrid)
            .addLocalDateField("Created date", entity.createdDateProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
