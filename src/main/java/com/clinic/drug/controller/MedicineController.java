package com.clinic.drug.controller;

import com.clinic.AbstractCrudController;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.repository.MedicineRepository;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MedicineController extends AbstractCrudController<Medicine, MedicineRepository>{
    public MedicineController() {
        super(Medicine.class, MedicineRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, int action) {
        Medicine entity = action == AbstractCrudController.CREATE_ACTION 
            ? new Medicine() 
            : entityTable.getSelectionModel().getSelectedItem();

        TextField genericNameField = new TextField();
        formGrid.addRow(1, new Label("Generic Name: "), genericNameField);
        genericNameField.textProperty().bindBidirectional(entity.genericNameProperty());

        TextField brandNameField = new TextField();
        formGrid.addRow(2, new Label("Brand Name: "), brandNameField);
        brandNameField.textProperty().bindBidirectional(entity.brandNameProperty());

        formGrid.add(generateSubmitButton("Submit", entity, action), 1, 3);
    }
}
