package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.PurchaseMedicineDetail;
import com.clinic.drug.repository.PurchaseMedicineDetailRepository;

import javafx.scene.layout.GridPane;

public class PurchaseMedicineDetailController extends AbstractCrudController<PurchaseMedicineDetail, PurchaseMedicineDetailRepository> {
    public PurchaseMedicineDetailController() {
        super(PurchaseMedicineDetail.class, PurchaseMedicineDetailRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, PurchaseMedicineDetail entity) {
        new GridFormBuilder(formGrid)
            .addBigDecimalField("Qty", entity.qtyProperty())
            .addIntegerField("Price/unit", entity.pricePerUnitProperty())
            .addPickField(
                "Header Id",
                entity.purchaseMedicineHeaderIdProperty(),
                new PurchaseMedicineHeaderController(),
                "getId"
            )
            .addButton(generateSubmitButton("Submit", entity));
    }
}
