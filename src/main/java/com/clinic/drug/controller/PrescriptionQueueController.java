package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PrescriptionQueue;
import com.clinic.drug.repository.PrescriptionQueueRepository;
import com.clinic.factories.CrudControllerFactory;

import javafx.scene.layout.GridPane;

public class PrescriptionQueueController extends AbstractCrudController<PrescriptionQueue, PrescriptionQueueRepository> {
    public PrescriptionQueueController() {
        super(PrescriptionQueue.class, PrescriptionQueueRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, PrescriptionQueue entity) {
        new GridFormBuilder(formGrid)
            .addPickField(
                "Prescription Header", 
                entity.prescriptionHeaderIdProperty(), 
                CrudControllerFactory.getController(PrescriptionHeaderController.class), 
                "getId"
            )
            .addIntegerField("Status", entity.statusProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
