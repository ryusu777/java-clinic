package com.clinic.drug.controller;

import java.sql.SQLException;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.DosageForm;
import com.clinic.drug.domain.DosageFormCategory;
import com.clinic.drug.repository.DosageFormCategoryRepository;
import com.clinic.drug.repository.DosageFormRepository;
import com.clinic.factories.EntityRepositoryFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
                        "getName")
                .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    public void fetchEntitiesToTable(MFXTableView<DosageForm> entityTable, String whereClause) {
        ObservableList<DosageForm> entities;
        try {
            entities = FXCollections.observableArrayList(repo.join(EntityRepositoryFactory.getRepository(DosageFormCategoryRepository.class), "dosage_form_category_id"));
            entityTable.setItems(entities);
            entityTable.autosize();
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }

    @Override
    protected void initTableViewSchema(MFXTableView<DosageForm> entityTable) {
        addTableColumn(entityTable, "Id", DosageForm::getId);
        addTableColumn(entityTable, "Name", DosageForm::getName);
        addTableColumn(entityTable, "Category", DosageForm::getDosageFormCategory, DosageFormCategory::getName);
    }
}
