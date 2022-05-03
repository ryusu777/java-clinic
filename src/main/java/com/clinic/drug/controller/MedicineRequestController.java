package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.MedicineRequest;
import com.clinic.drug.repository.MedicineRequestRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class MedicineRequestController extends AbstractCrudController<MedicineRequest, MedicineRequestRepository> {

    public MedicineRequestController() {
        super(MedicineRequest.class, MedicineRequestRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, MedicineRequest entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Generic Name", entity.genericNameProperty())
            .addTextField("Brand Name", entity.brandNameProperty())
            // TODO: Combobox for status
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<MedicineRequest> entityTable) {
        addTableColumn(entityTable, "Id", MedicineRequest::getId);
        addTableColumn(entityTable, "Brand Name", MedicineRequest::getBrandName);
        addTableColumn(entityTable, "Generic Name", MedicineRequest::getGenericName);
        addTableColumn(entityTable, "Status", MedicineRequest::getStatus);
    }
}
