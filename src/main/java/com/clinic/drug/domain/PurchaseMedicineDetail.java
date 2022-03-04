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

    public void setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPurchaseMedicineHeaderId() {
        return purchaseMedicineHeaderId;
    }

    public void setPurchaseMedicineHeaderId(Integer purchaseMedicineHeaderId) {
        this.purchaseMedicineHeaderId = purchaseMedicineHeaderId;
    }
}
