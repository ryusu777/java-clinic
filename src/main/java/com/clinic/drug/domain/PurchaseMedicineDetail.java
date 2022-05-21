package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PurchaseMedicineDetail extends BaseTransactionDetail implements ICopyable<PurchaseMedicineDetail> {
    public PurchaseMedicineDetail() {
        this(null);
    }

    public PurchaseMedicineDetail(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        List<String> result = super.getTableFieldNames();
        result.addAll(Arrays.asList("purchase_medicine_header_id"));
        return result;
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
        return (PurchaseMedicineDetail) this
            .setPurchaseMedicineHeaderId(entity.getPurchaseMedicineHeaderId())
            .setPricePerUnit(entity.getPricePerUnit())
            .setQty(entity.getQty());
    }
}
