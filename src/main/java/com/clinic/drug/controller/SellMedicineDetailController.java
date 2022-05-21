package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.SellMedicineDetail;
import com.clinic.drug.repository.SellMedicineDetailRepository;
import com.clinic.factories.CrudControllerFactory;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class SellMedicineDetailController extends AbstractCrudController<SellMedicineDetail, SellMedicineDetailRepository> {
    public SellMedicineDetailController() {
        super(SellMedicineDetail.class, SellMedicineDetailRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, SellMedicineDetail entity) {
        new GridFormBuilder(formGrid)
            .addIntegerField("Price per unit", entity.pricePerUnitProperty())
            .addPickField(
                "Header Id", 
                entity.sellMedicineHeaderIdPropery(), 
                CrudControllerFactory.getController(SellMedicineHeaderController.class), 
                "getId"
            )
            .addPickField(
                "Prescription Recipe", 
                entity.prescriptionRecipeIdPropery(), 
                CrudControllerFactory.getController(PrescriptionRecipeController.class), 
                "getId"
            )
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<SellMedicineDetail> entityTable) {
        addTableColumn(entityTable, "Id", SellMedicineDetail::getId);
        addTableColumn(entityTable, "Price/unit", SellMedicineDetail::getPricePerUnit);
        addTableColumn(entityTable, "Header Id", SellMedicineDetail::getSellMedicineHeaderId);
        addTableColumn(entityTable, "Prescription Id", SellMedicineDetail::getPrescriptionRecipeId);
    }
}
