package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PurchaseMedicineDetail extends AbstractEntity {
    public PurchaseMedicineDetail() {
        this(null);
    }

    public PurchaseMedicineDetail(Integer id) {
        super(id);
        pricePerUnit = new SimpleIntegerProperty();
        qty = new SimpleIntegerProperty();
        purchaseMedicineHeaderId = new SimpleIntegerProperty();
    }
    
    private IntegerProperty pricePerUnit, qty, purchaseMedicineHeaderId;

    public IntegerProperty pricePerUnitProperty() {
        return this.pricePerUnit;
    }

    public IntegerProperty qtyProperty() {
        return this.qty;
    }

    public IntegerProperty purchaseMedicineHeaderIdProperty() {
        return this.purchaseMedicineHeaderId;
    }

    public Integer getPricePerUnit() {
        return pricePerUnit.get();
    }

    public PurchaseMedicineDetail setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit.setValue(pricePerUnit);
        return this;
    }

    public Integer getQty() {
        return qty.get();
    }

    public PurchaseMedicineDetail setQty(Integer qty) {
        this.qty.setValue(qty);
        return this;
    }

    public Integer getPurchaseMedicineHeaderId() {
        return purchaseMedicineHeaderId.get();
    }

    public PurchaseMedicineDetail setPurchaseMedicineHeaderId(Integer purchaseMedicineHeaderId) {
        this.purchaseMedicineHeaderId.setValue(purchaseMedicineHeaderId);
        return this;
    }
}
