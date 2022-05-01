package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

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
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "price_per_unit",
            "qty",
            "purchase_medicine_header_id"
        );
    }

    private IntegerProperty pricePerUnit = new SimpleIntegerProperty();
    public IntegerProperty pricePerUnitProperty() {
        return this.pricePerUnit;
    }

    public Integer getPricePerUnit() {
        return pricePerUnit.get();
    }

    public PurchaseMedicineDetail setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit.setValue(pricePerUnit);
        return this;
    }

    private ObjectProperty<BigDecimal> qty = new SimpleObjectProperty<>();
    public ObjectProperty<BigDecimal> qtyProperty() {
        return this.qty;
    }

    public BigDecimal getQty() {
        return qty.get();
    }

    public PurchaseMedicineDetail setQty(BigDecimal qty) {
        this.qty.setValue(qty);
        return this;
    }

    private IntegerProperty purchaseMedicineHeaderId = new SimpleIntegerProperty();
    public IntegerProperty purchaseMedicineHeaderIdProperty() {
        return this.purchaseMedicineHeaderId;
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
