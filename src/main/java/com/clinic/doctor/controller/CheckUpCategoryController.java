package com.clinic.doctor.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.doctor.domain.CheckUpCategory;
import com.clinic.doctor.repository.CheckUpCategoryRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class CheckUpCategoryController extends AbstractCrudController<CheckUpCategory, CheckUpCategoryRepository>{
    public CheckUpCategoryController() {
        super(CheckUpCategory.class, CheckUpCategoryRepository.class, "CHECK UP CATEGORY");
    }

    @Override
    protected void setFormGrid(GridPane formGrid, CheckUpCategory entity) {
        new GridFormBuilder(formGrid)
            .addTextField("Category Name: ", entity.categoryNameProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<CheckUpCategory> entityTable) {
        addTableColumn(entityTable, "Id", CheckUpCategory::getId);
        addTableColumn(entityTable, "Category Name", CheckUpCategory::getCategoryName);
    }
}
