package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PrescriptionIngredient extends AbstractEntity {
    public PrescriptionIngredient() {
        this(null);
    }

    public PrescriptionIngredient(Integer id) {
        super(id);
        qty = new SimpleIntegerProperty();
        prescriptionRecipeId = new SimpleIntegerProperty();
        medicineStockId = new SimpleIntegerProperty();
    }
    
    private IntegerProperty qty, prescriptionRecipeId, medicineStockId;

    public IntegerProperty qtyProperty() {
        return this.qty;
    }

    public IntegerProperty prescriptionRecipeIdProperty() {
        return this.prescriptionRecipeId;
    }

    public IntegerProperty medicineStockIdProperty() {
        return this.medicineStockId;
    }

    public Integer getQty() {
        return qty.get();
    }

    public PrescriptionIngredient setQty(Integer qty) {
        this.qty.setValue(qty);
        return this;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId.get();
    }

    public PrescriptionIngredient setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId.setValue(prescriptionRecipeId);
        return this;
    }

    public Integer getMedicineStockId() {
        return medicineStockId.get();
    }

    public PrescriptionIngredient setMedicineStockId(Integer medicineStockId) {
        this.medicineStockId.setValue(medicineStockId);
        return this;
    }
    
}
