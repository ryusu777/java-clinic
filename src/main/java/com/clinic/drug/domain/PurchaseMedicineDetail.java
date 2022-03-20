package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class PurchaseMedicineDetail extends AbstractEntity {
    public PurchaseMedicineDetail() {
        super(null);
    }

    public PurchaseMedicineDetail(Integer id) {
        super(id);
    }
    
    private Integer pricePerUnit, qty, purchaseMedicineHeaderId;

    public Integer getPricePerUnit() {
        return pricePerUnit;
    }

    public PurchaseMedicineDetail setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
        return this;
    }

    public Integer getQty() {
        return qty;
    }

    public PurchaseMedicineDetail setQty(Integer qty) {
        this.qty = qty;
        return this;
    }

    public Integer getPurchaseMedicineHeaderId() {
        return purchaseMedicineHeaderId;
    }

    public PurchaseMedicineDetail setPurchaseMedicineHeaderId(Integer purchaseMedicineHeaderId) {
        this.purchaseMedicineHeaderId = purchaseMedicineHeaderId;
        return this;
    }
}
