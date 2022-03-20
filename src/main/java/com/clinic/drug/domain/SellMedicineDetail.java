package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class SellMedicineDetail extends AbstractEntity {
    public SellMedicineDetail() {
        super(null);
    }

    public SellMedicineDetail(Integer id) {
        super(id);
    }
    
    private Integer price, sellMedicineHeaderId, prescriptionRecipeId;

    public Integer getPrice() {
        return price;
    }

    public SellMedicineDetail setPrice(Integer price) {
        this.price = price;
        return this;
    }

    public Integer getSellMedicineHeaderId() {
        return sellMedicineHeaderId;
    }

    public SellMedicineDetail setSellMedicineHeaderId(Integer sellMedicineHeaderId) {
        this.sellMedicineHeaderId = sellMedicineHeaderId;
        return this;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId;
    }

    public SellMedicineDetail setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId = prescriptionRecipeId;
        return this;
    }
    
}
