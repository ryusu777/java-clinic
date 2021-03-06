package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PrescriptionRecipe;
import com.clinic.drug.repository.PrescriptionRecipeRepository;
import com.clinic.factories.CrudControllerFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class PrescriptionRecipeController extends AbstractCrudController<PrescriptionRecipe, PrescriptionRecipeRepository> {
    public PrescriptionRecipeController() {
        super(PrescriptionRecipe.class, PrescriptionRecipeRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, PrescriptionRecipe entity) {
        new GridFormBuilder(formGrid)
        .addTextField("Latin Making Instruction", entity.latinMakingInstructionProperty())
        .addTextField("Latin Usage Instruction", entity.latinUsageInstructionProperty())
        .addTextField("Usage Instruction", entity.usageInstructionProperty())
        .addBigDecimalField("Qty", entity.qtyProperty())
        .addLocalDateField("Exp Date", entity.expDateProperty())
        .addPickField(
            "Dosage Form", 
            entity.dosageFormIdProperty(), 
            CrudControllerFactory.getController(DosageFormController.class), 
            "getName"
        )
        .addPickField(
            "Prescription Header", 
            entity.prescriptionHeaderIdProperty(), 
            CrudControllerFactory.getController(PrescriptionHeaderController.class),
            "getId"
        )
        .addButton(generateSubmitButton("submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<PrescriptionRecipe> entityTable) {
        addTableColumn(entityTable, "Id", PrescriptionRecipe::getId);
        addTableColumn(entityTable, "Qty", PrescriptionRecipe::getQty);
        addTableColumn(entityTable, "Exp Date", PrescriptionRecipe::getExpDate);
        addTableColumn(entityTable, "Usage Instruction", PrescriptionRecipe::getUsageInstruction);
        addTableColumn(entityTable, "Latin Making Instruction", PrescriptionRecipe::getLatinMakingInstruction);
        addTableColumn(entityTable, "Latin Usage Instruction", PrescriptionRecipe::getLatinUsageInstruction);
        addTableColumn(entityTable, "Dosage Form Id", PrescriptionRecipe::getDosageFormId);
        addTableColumn(entityTable, "Prescription Header Id", PrescriptionRecipe::getPrescriptionHeaderId);
    }
}
