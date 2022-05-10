package com.clinic.doctor.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.doctor.domain.CheckUpDetail;
import com.clinic.doctor.repository.CheckUpDetailRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class CheckUpDetailController extends AbstractCrudController<CheckUpDetail, CheckUpDetailRepository>{
    public CheckUpDetailController() {
        super(CheckUpDetail.class, CheckUpDetailRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, CheckUpDetail entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Check Up Result: ", entity.checkUpResultProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<CheckUpDetail> entityTable) {
        addTableColumn(entityTable, "Id", CheckUpDetail::getId);
        addTableColumn(entityTable, "Check Up Result", CheckUpDetail::getCheckUpResult);
        addTableColumn(entityTable, "Category Id", CheckUpDetail::getCheckUpCategoryId);
        addTableColumn(entityTable, "Medical Record Id", CheckUpDetail::getMedicalRecordId);
    }
}