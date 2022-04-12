package com.clinic.drug.domain;

import java.math.BigDecimal;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PurchaseMedicineDetail extends AbstractEntity implements Copyable<PurchaseMedicineDetail> {
    public PurchaseMedicineDetail() {
        this(null);
    }

    public PurchaseMedicineDetail(Integer id) {
        super(id);
        pricePerUnit = new SimpleIntegerProperty();
        qty = new SimpleObjectProperty<>();
        purchaseMedicineHeaderId = new SimpleIntegerProperty();
    }
    
    private IntegerProperty pricePerUnit, purchaseMedicineHeaderId;
    private ObjectProperty<BigDecimal> qty;

    public IntegerProperty pricePerUnitProperty() {
        return this.pricePerUnit;
    }

    public ObjectProperty<BigDecimal> qtyProperty() {
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

    public BigDecimal getQty() {
        return qty.get();
    }

    public PurchaseMedicineDetail setQty(BigDecimal qty) {
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

    @Override
    public PurchaseMedicineDetail copy(PurchaseMedicineDetail entity) {
        return this
            .setPricePerUnit(entity.getPricePerUnit())
            .setPurchaseMedicineHeaderId(entity.getPurchaseMedicineHeaderId())
            .setQty(entity.getQty());
    }
}
