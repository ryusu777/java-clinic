package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.SellMedicineHeader;
import com.clinic.drug.repository.SellMedicineHeaderRepository;
import com.clinic.factories.CrudControllerFactory;

import javafx.scene.layout.GridPane;

public class SellMedicineHeaderController extends AbstractCrudController<SellMedicineHeader, SellMedicineHeaderRepository> {
    public SellMedicineHeaderController() {
        super(SellMedicineHeader.class, SellMedicineHeaderRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, SellMedicineHeader entity) {
        new GridFormBuilder(formGrid)
            .addPickField(
                "Prescription Header", 
                entity.prescriptionHeaderIdProperty(), 
                CrudControllerFactory.getController(PrescriptionHeaderController.class), 
                "getId"
            )
            .addLocalDateField("Purchase Date", entity.purchaseDateProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
