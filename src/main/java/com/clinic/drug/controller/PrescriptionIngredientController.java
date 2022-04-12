package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PrescriptionIngredient;
import com.clinic.drug.repository.PrescriptionIngredientRepository;
import com.clinic.factories.CrudControllerFactory;

import javafx.scene.layout.GridPane;

public class PrescriptionIngredientController extends AbstractCrudController<PrescriptionIngredient, PrescriptionIngredientRepository> {
    public PrescriptionIngredientController() {
        super(PrescriptionIngredient.class, PrescriptionIngredientRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, PrescriptionIngredient entity) {
        new GridFormBuilder(formGrid)
            .addPickField(
                "Medicine Stock", 
                entity.medicineStockIdProperty(), 
                CrudControllerFactory.getController(MedicineStockController.class), 
                "getId"
            )
            .addPickField(
                "Prescription Recipe", 
                entity.prescriptionRecipeIdProperty(), 
                CrudControllerFactory.getController(PrescriptionRecipeController.class), 
                "getId"
            )
            .addBigDecimalField("Qty", entity.qtyProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
