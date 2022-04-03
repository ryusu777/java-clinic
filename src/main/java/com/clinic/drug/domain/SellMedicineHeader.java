package com.clinic.drug.domain;

import java.sql.Date;

import com.clinic.AbstractEntity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class SellMedicineHeader extends AbstractEntity {
    public SellMedicineHeader() {
        this(null);
    }

    public SellMedicineHeader(Integer id) {
        super(id);
        purchaseDate = new SimpleObjectProperty<>();
        prescriptionHeaderId = new SimpleIntegerProperty();
    }
    
    private ObjectProperty<Date> purchaseDate;
    private IntegerProperty prescriptionHeaderId;

    public ObjectProperty<Date> purchaseDateProperty() {
        return purchaseDate;
    }

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

    public Date getPurchaseDate() {
        return purchaseDate.get();
    }

    public SellMedicineHeader setPurchaseDate(Date purchaseDate) {
        this.purchaseDate.setValue(purchaseDate);
        return this;
    }
}
