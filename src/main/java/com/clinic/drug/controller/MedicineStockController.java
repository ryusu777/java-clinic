package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.MedicineStock;
import com.clinic.drug.repository.MedicineStockRepository;
import com.clinic.factories.CrudControllerFactory;

import javafx.scene.layout.GridPane;

public class MedicineStockController extends AbstractCrudController<MedicineStock, MedicineStockRepository> {
    public MedicineStockController() {
        super(MedicineStock.class, MedicineStockRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, MedicineStock entity) {
        new GridFormBuilder(formGrid)
            .addPickField(
                "Medicine",
                entity.medicineIdProperty(),
                CrudControllerFactory.getController(MedicineController.class),
                "getBrandName"
            )
            .addPickField(
                "Qty Unit",
                entity.qtyUnitIdProperty(),
                CrudControllerFactory.getController(QtyUnitController.class),
                "getName"
            )
            .addPickField(
                "Dosage Form",
                entity.dosageFormIdProperty(),
                CrudControllerFactory.getController(DosageFormController.class),
                "getName"
            )
            .addLocalDateTimeField("Received Date", entity.receivedDateProperty())
            .addLocalDateField("Exp Date", entity.expDateProperty())
            .addTextField("Batch Number", entity.batchNumberProperty())
            .addBigDecimalField("Qty Available", entity.qtyAvailableProperty())
            .addBigDecimalField("Qty To Dosage Form Multiplier", entity.qtyToDosageFormMultiplierProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
