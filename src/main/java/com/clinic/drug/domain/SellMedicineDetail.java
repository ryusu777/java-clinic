package com.clinic.drug.domain;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SellMedicineDetail extends AbstractEntity implements Copyable<SellMedicineDetail> {
    public SellMedicineDetail() {
        this(null);
    }

    public SellMedicineDetail(Integer id) {
        super(id);
        price = new SimpleIntegerProperty();
        sellMedicineHeaderId = new SimpleIntegerProperty();
        prescriptionRecipeId = new SimpleIntegerProperty();
    }
    
    private IntegerProperty price, sellMedicineHeaderId, prescriptionRecipeId;

    public IntegerProperty pricePropery() {
        return price;
    }

    public IntegerProperty sellMedicineHeaderIdPropery() {
        return sellMedicineHeaderId;
    }

    public IntegerProperty prescriptionRecipeIdPropery() {
        return prescriptionRecipeId;
    }

    public Integer getPrice() {
        return price.get();
    }

    public SellMedicineDetail setPrice(Integer price) {
        this.price.setValue(price);
        return this;
    }

    public Integer getSellMedicineHeaderId() {
        return sellMedicineHeaderId.get();
    }

    public SellMedicineDetail setSellMedicineHeaderId(Integer sellMedicineHeaderId) {
        this.sellMedicineHeaderId.setValue(sellMedicineHeaderId);
        return this;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId.get();
    }

    public SellMedicineDetail setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId.setValue(prescriptionRecipeId);
        return this;
    }

    @Override
    public SellMedicineDetail copy(SellMedicineDetail entity) {
        return this
            .setPrescriptionRecipeId(entity.getPrescriptionRecipeId())
            .setPrice(entity.getPrice())
            .setSellMedicineHeaderId(entity.getSellMedicineHeaderId());
    }
}