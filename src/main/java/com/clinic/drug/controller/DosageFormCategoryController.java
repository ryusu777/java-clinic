package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.DosageFormCategory;
import com.clinic.drug.repository.DosageFormCategoryRepository;
import com.clinic.factories.CrudControllerFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class DosageFormCategoryController extends AbstractCrudController<DosageFormCategory, DosageFormCategoryRepository> {
    public DosageFormCategoryController() {
        super(DosageFormCategory.class, DosageFormCategoryRepository.class);
        childControllers.add(CrudControllerFactory.getController(DosageFormController.class));
    }

    @Override
    protected void setFormGrid(GridPane formGrid, DosageFormCategory entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Category Name", entity.nameProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<DosageFormCategory> entityTable) {
        addTableColumn(entityTable, "Id", DosageFormCategory::getId);
        addTableColumn(entityTable, "Name", DosageFormCategory::getName);
    }
}
