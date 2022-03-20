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

    public PrescriptionIngredient setQty(Integer qty) {
        this.qty = qty;
        return this;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId;
    }

    public PrescriptionIngredient setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId = prescriptionRecipeId;
        return this;
    }

    public Integer getMedicineStockId() {
        return medicineStockId;
    }

    public PrescriptionIngredient setMedicineStockId(Integer medicineStockId) {
        this.medicineStockId = medicineStockId;
        return this;
    }
    
}
