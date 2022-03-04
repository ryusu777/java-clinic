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

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getSellMedicineHeaderId() {
        return sellMedicineHeaderId;
    }

    public void setSellMedicineHeaderId(Integer sellMedicineHeaderId) {
        this.sellMedicineHeaderId = sellMedicineHeaderId;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId;
    }

    public void setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId = prescriptionRecipeId;
    }
    
}
