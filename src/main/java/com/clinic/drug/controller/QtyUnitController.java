package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.QtyUnit;
import com.clinic.drug.repository.QtyUnitRepository;

import javafx.scene.layout.GridPane;

public class QtyUnitController extends AbstractCrudController<QtyUnit, QtyUnitRepository> {
    public QtyUnitController() {
        super(QtyUnit.class, QtyUnitRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, QtyUnit entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Name", entity.nameProperty())
            .addTextField("Short Name", entity.shortNameProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
