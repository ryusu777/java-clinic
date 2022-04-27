package com.clinic.drug.domain;

import java.time.LocalDate;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SellMedicineHeader extends AbstractEntity implements Copyable<SellMedicineHeader> {
    public SellMedicineHeader() {
        this(null);
    }

    public SellMedicineHeader(Integer id) {
        super(id);
    }
    
    private ObjectProperty<LocalDate> purchaseDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> purchaseDateProperty() {
        return purchaseDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate.get();
    }

    public SellMedicineHeader setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate.setValue(purchaseDate);
        return this;
    }

    private IntegerProperty prescriptionHeaderId = new SimpleIntegerProperty();
    public IntegerProperty prescriptionHeaderIdProperty() {
        return prescriptionHeaderId;
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId.get();
    }

    public SellMedicineHeader setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId.setValue(prescriptionHeaderId);
        return this;
    }

    @Override
    public SellMedicineHeader copy(SellMedicineHeader entity) {
        return this
            .setPrescriptionHeaderId(entity.getPrescriptionHeaderId())
            .setPurchaseDate(entity.getPurchaseDate());
    }
}
