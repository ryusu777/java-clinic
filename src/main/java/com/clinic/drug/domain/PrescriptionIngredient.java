package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class PrescriptionIngredient extends AbstractEntity {
    public PrescriptionIngredient() {
        super(null);
    }

    public PrescriptionIngredient(Integer id) {
        super(id);
    }
    
    private Integer qty, prescriptionRecipeId, medicineStockId;

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId;
    }

    public void setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId = prescriptionRecipeId;
    }

    public Integer getMedicineStockId() {
        return medicineStockId;
    }

    public void setMedicineStockId(Integer medicineStockId) {
        this.medicineStockId = medicineStockId;
    }
    
}
