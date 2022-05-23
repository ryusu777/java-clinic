package com.clinic.drug.controller;

import java.sql.SQLException;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.DosageForm;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.domain.MedicineStock;
import com.clinic.drug.repository.DosageFormRepository;
import com.clinic.drug.repository.MedicineRepository;
import com.clinic.drug.repository.MedicineStockRepository;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    public void fetchEntitiesToTable(MFXTableView<MedicineStock> entityTable, String whereClause) {
        ObservableList<MedicineStock> entities;
        try {
            entities = FXCollections
                .observableArrayList(repo
                    .join(
                        EntityRepositoryFactory.getRepository(MedicineRepository.class),
                        EntityRepositoryFactory.getRepository(DosageFormRepository.class),
                        "medicine_id", 
                        "dosage_form_id", 
                        whereClause)
                );
            entityTable.setItems(entities);
            entityTable.autosize();
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }

    @Override
    protected void initTableViewSchema(MFXTableView<MedicineStock> entityTable) {
        addTableColumn(entityTable, "Id", MedicineStock::getId);
        addTableColumn(entityTable, "Brand Name", MedicineStock::getMedicine, Medicine::getBrandName);
        addTableColumn(entityTable, "Generic Name", MedicineStock::getMedicine, Medicine::getGenericName);
        addTableColumn(entityTable, "Dosage Form", MedicineStock::getDosageForm, DosageForm::getName);
        addTableColumn(entityTable, "Qty Available", MedicineStock::getQtyAvailable);
        addTableColumn(entityTable, "Exp Date", MedicineStock::getExpDate);
        addTableColumn(entityTable, "Received Date", MedicineStock::getReceivedDate);
        addTableColumn(entityTable, "Batch Number", MedicineStock::getBatchNumber);
        addTableColumn(entityTable, "HRP", MedicineStock::getHighestRetailPrice);
    }
}
