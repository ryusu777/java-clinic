package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.repository.MedicineRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class MedicineController extends AbstractCrudController<Medicine, MedicineRepository>{
    public MedicineController() {
        super(Medicine.class, MedicineRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, Medicine entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Generic Name", entity.genericNameProperty())
            .addTextField("Brand Name", entity.brandNameProperty())
            // TODO: add combo box for medicine type
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<Medicine> entityTable) {
        addTableColumn(entityTable, "Id", Medicine::getId);
        addTableColumn(entityTable, "Brand Name", Medicine::getBrandName);
        addTableColumn(entityTable, "Generic Name", Medicine::getGenericName);
        addTableColumn(entityTable, "Medicine Type", Medicine::getMedicineType);
    }
}
