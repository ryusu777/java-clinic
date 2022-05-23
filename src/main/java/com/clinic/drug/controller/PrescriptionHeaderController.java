package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PrescriptionHeader;
import com.clinic.drug.repository.PrescriptionHeaderRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
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

    @Override
    protected void initTableViewSchema(MFXTableView<PrescriptionHeader> entityTable) {
        addTableColumn(entityTable, "Id", PrescriptionHeader::getId);
        addTableColumn(entityTable, "Created Date", PrescriptionHeader::getCreatedDate);
        addTableColumn(entityTable, "Doctor Id", PrescriptionHeader::getDoctorId);
        addTableColumn(entityTable, "Patient Id", PrescriptionHeader::getPatientId);
        addTableColumn(entityTable, "Medical Record Id", PrescriptionHeader::getMedicalRecordId);
    }
}
