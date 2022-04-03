package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.clinic.AbstractEntity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class MedicineStock extends AbstractEntity {
    public MedicineStock() {
        this(null);
    }

    public MedicineStock(Integer id) {
        super(id);
        receivedDate = new SimpleObjectProperty<>();
        expDate = new SimpleObjectProperty<>();
        qtyAvailable = new SimpleObjectProperty<>();
        qtyToDosageFormMultiplier = new SimpleObjectProperty<>();
        medicineId = new SimpleIntegerProperty();
        dosageFormId = new SimpleIntegerProperty();
        qtyUnitId = new SimpleIntegerProperty();
    }
    
    private ObjectProperty<Timestamp> receivedDate;
    private ObjectProperty<Date> expDate;
    private ObjectProperty<BigDecimal> qtyAvailable, qtyToDosageFormMultiplier;
    private IntegerProperty medicineId, dosageFormId, qtyUnitId;

    public ObjectProperty<Timestamp> receivedDateProperty() {
        return this.receivedDate;
    }

    public ObjectProperty<Date> expDateProperty() {
        return this.expDate;
    }

    public ObjectProperty<BigDecimal> qtyAvailableProperty() {
        return this.qtyAvailable;
    }

    public ObjectProperty<BigDecimal> qtyToDosageFormMultiplierProperty() {
        return this.qtyToDosageFormMultiplier;
    }

    public IntegerProperty medicineIdProperty() {
        return this.medicineId;
    }

    public IntegerProperty dosageFormIdProperty() {
        return this.dosageFormId;
    }

    public IntegerProperty qtyUnitIdProperty() {
        return this.qtyUnitId;
    }

    public Timestamp getReceivedDate() {
        return receivedDate.get();
    }

    public MedicineStock setReceivedDate(Timestamp receivedDate) {
        this.receivedDate.setValue(receivedDate);
        return this;
    }

    public Date getExpDate() {
        return expDate.get();
    }

    public MedicineStock setExpDate(Date expDate) {
        this.expDate.setValue(expDate);
        return this;
    }

    public BigDecimal getQtyToDosageFormMultiplier() {
        return qtyToDosageFormMultiplier.get();
    }

    public void setQtyToDosageFormMultiplier(BigDecimal qtyToDosageFormMultiplier) {
        this.qtyToDosageFormMultiplier.setValue(qtyToDosageFormMultiplier);
    }

    public BigDecimal getQtyAvailable() {
        return qtyAvailable.get();
    }

    public MedicineStock setQtyAvailable(BigDecimal qtyAvailable) {
        this.qtyAvailable.setValue(qtyAvailable);
        return this;
    }

    public Integer getMedicineId() {
        return medicineId.get();
    }

    public MedicineStock setMedicineId(Integer medicineId) {
        this.medicineId.setValue(medicineId);
        return this;
    }

    public Integer getQtyUnitId() {
        return qtyUnitId.get();
    }

    public MedicineStock setQtyUnitId(Integer qtyUnitId) {
        this.qtyUnitId.setValue(qtyUnitId);
        return this;
    }

    public Integer getDosageFormId() {
        return dosageFormId.get();
    }

    public MedicineStock setDosageFormId(Integer dosageFormId) {
        this.dosageFormId.setValue(dosageFormId);
        return this;
    }
}
