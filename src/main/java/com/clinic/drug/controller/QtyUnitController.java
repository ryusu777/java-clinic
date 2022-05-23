package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.QtyUnit;
import com.clinic.drug.repository.QtyUnitRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
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

    @Override
    protected void initTableViewSchema(MFXTableView<QtyUnit> entityTable) {
        addTableColumn(entityTable, "Id", QtyUnit::getId);
        addTableColumn(entityTable, "Name", QtyUnit::getName);
        addTableColumn(entityTable, "Short Name", QtyUnit::getShortName);
    }
}
