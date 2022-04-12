package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PurchaseMedicineHeader;
import com.clinic.drug.repository.PurchaseMedicineHeaderRepository;

import javafx.scene.layout.GridPane;

public class PurchaseMedicineHeaderController extends AbstractCrudController<PurchaseMedicineHeader, PurchaseMedicineHeaderRepository> {
    public PurchaseMedicineHeaderController() {
        super(PurchaseMedicineHeader.class, PurchaseMedicineHeaderRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, PurchaseMedicineHeader entity) {
        new GridFormBuilder(formGrid)
            .addLocalDateField("Purchase Date", entity.purchaseDateProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
}
