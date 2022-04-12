package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.SellMedicineDetail;
import com.clinic.drug.repository.SellMedicineDetailRepository;
import com.clinic.factories.CrudControllerFactory;

import javafx.scene.layout.GridPane;

public class SellMedicineDetailController extends AbstractCrudController<SellMedicineDetail, SellMedicineDetailRepository> {
    public SellMedicineDetailController() {
        super(SellMedicineDetail.class, SellMedicineDetailRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, SellMedicineDetail entity) {
        new GridFormBuilder(formGrid)
            .addIntegerField("Price", entity.pricePropery())
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
}
