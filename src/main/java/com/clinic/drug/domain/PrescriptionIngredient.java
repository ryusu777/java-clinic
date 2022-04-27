package com.clinic.drug.domain;

import java.math.BigDecimal;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PrescriptionIngredient extends AbstractEntity implements Copyable<PrescriptionIngredient> {
    public PrescriptionIngredient() {
        this(null);
    }

    public PrescriptionIngredient(Integer id) {
        super(id);
    }

    private ObjectProperty<BigDecimal> qty = new SimpleObjectProperty<>();
    public ObjectProperty<BigDecimal> qtyProperty() {
        return this.qty;
    }

    public BigDecimal getQty() {
        return qty.get();
    }

    public PrescriptionIngredient setQty(BigDecimal qty) {
        this.qty.setValue(qty);
        return this;
    }

    private IntegerProperty prescriptionRecipeId = new SimpleIntegerProperty();
    public IntegerProperty prescriptionRecipeIdProperty() {
        return this.prescriptionRecipeId;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId.get();
    }

    public PrescriptionIngredient setPrescriptionRecipeId(Integer prescriptionRecipeId) {
        this.prescriptionRecipeId.setValue(prescriptionRecipeId);
        return this;
    }

    private IntegerProperty medicineStockId = new SimpleIntegerProperty();
    public IntegerProperty medicineStockIdProperty() {
        return this.medicineStockId;
    }

    public Integer getMedicineStockId() {
        return medicineStockId.get();
    }

    public PrescriptionIngredient setMedicineStockId(Integer medicineStockId) {
        this.medicineStockId.setValue(medicineStockId);
        return this;
    }

    @Override
    public PrescriptionIngredient copy(PrescriptionIngredient entity) {
        return this
            .setMedicineStockId(entity.getMedicineStockId())
            .setPrescriptionRecipeId(entity.getPrescriptionRecipeId())
            .setQty(entity.getQty());
    }
}
