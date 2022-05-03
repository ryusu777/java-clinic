package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.MedicineStock;
import com.clinic.drug.repository.MedicineStockRepository;
import com.clinic.factories.CrudControllerFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
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
            .addIntegerField("Highest Retail Price", entity.highestRetailPriceProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<MedicineStock> entityTable) {
        addTableColumn(entityTable, "Id", MedicineStock::getId);
        addTableColumn(entityTable, "Medicine Id", MedicineStock::getMedicineId);
        addTableColumn(entityTable, "Qty Available", MedicineStock::getQtyAvailable);
        addTableColumn(entityTable, "Qty to Dosage Form Multiplier", MedicineStock::getQtyToDosageFormMultiplier);
        addTableColumn(entityTable, "Qty Unit Id", MedicineStock::getQtyUnitId);
        addTableColumn(entityTable, "Exp Date", MedicineStock::getExpDate);
        addTableColumn(entityTable, "Received Date", MedicineStock::getReceivedDate);
        addTableColumn(entityTable, "Dosage Form Id", MedicineStock::getDosageFormId);
        addTableColumn(entityTable, "Batch Number", MedicineStock::getBatchNumber);
        addTableColumn(entityTable, "HRP", MedicineStock::getHighestRetailPrice);
        addTableColumn(entityTable, "Purchase Detail Id", MedicineStock::getPurchaseMedicineDetailId);
    }
}
