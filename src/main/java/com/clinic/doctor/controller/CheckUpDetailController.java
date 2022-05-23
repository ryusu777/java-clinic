package com.clinic.doctor.controller;

import java.sql.SQLException;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.doctor.domain.CheckUpCategory;
import com.clinic.doctor.domain.CheckUpDetail;
import com.clinic.doctor.domain.MedicalRecord;
import com.clinic.doctor.repository.CheckUpCategoryRepository;
import com.clinic.doctor.repository.CheckUpDetailRepository;
import com.clinic.doctor.repository.MedicalRecordRepository;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class CheckUpDetailController extends AbstractCrudController<CheckUpDetail, CheckUpDetailRepository>{
    public CheckUpDetailController() {
        super(CheckUpDetail.class, CheckUpDetailRepository.class, "CHECK UP DETAIL");
    }

    @Override
    protected void setFormGrid(GridPane formGrid, CheckUpDetail entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Check Up Result: ", entity.checkUpResultProperty())
            .addPickField("Check Up Category ID: ", 
                entity.checkUpCategoryIdProperty(),
                CrudControllerFactory.getController(CheckUpCategoryController.class), 
                "getCategoryName")
            .addPickField(
                "Medical Record ID: ", 
                entity.medicalRecordIdProperty(), 
                CrudControllerFactory.getController(MedicalRecordController.class), 
                "getPatientId")

            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    public void fetchEntitiesToTable(MFXTableView<CheckUpDetail> entityTable, String whereClause) {
        ObservableList<CheckUpDetail> entities;
        try {
            entities = FXCollections.observableArrayList(repo.join(EntityRepositoryFactory.getRepository(MedicalRecordRepository.class), EntityRepositoryFactory.getRepository(CheckUpCategoryRepository.class), "medical_record_id", "check_up_category_id"));
            entityTable.setItems(entities);
            entityTable.autosize();
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }

    @Override
    protected void initTableViewSchema(MFXTableView<CheckUpDetail> entityTable) {
        addTableColumn(entityTable, "Id", CheckUpDetail::getId);
        addTableColumn(entityTable, "Medical Record Id", CheckUpDetail::getMedicalRecord, MedicalRecord::getPatientId);
        addTableColumn(entityTable, "Category Name", CheckUpDetail::getCheckUpCategory, CheckUpCategory::getCategoryName);
        addTableColumn(entityTable, "Check Up Result", CheckUpDetail::getCheckUpResult);
    }
}