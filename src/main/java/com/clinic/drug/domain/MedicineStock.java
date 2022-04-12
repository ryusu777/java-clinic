package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicineStock extends AbstractEntity implements Copyable<MedicineStock> {
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
        batchNumber = new SimpleStringProperty();
    }
    
    private ObjectProperty<LocalDateTime> receivedDate;
    private ObjectProperty<LocalDate> expDate;
    private ObjectProperty<BigDecimal> qtyAvailable, qtyToDosageFormMultiplier;
    private IntegerProperty medicineId, dosageFormId, qtyUnitId;
    private StringProperty batchNumber;

    public ObjectProperty<LocalDateTime> receivedDateProperty() {
        return this.receivedDate;
    }

    public ObjectProperty<LocalDate> expDateProperty() {
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

    public StringProperty batchNumberProperty() {
        return batchNumber;
    }

    public IntegerProperty dosageFormIdProperty() {
        return this.dosageFormId;
    }

    public IntegerProperty qtyUnitIdProperty() {
        return this.qtyUnitId;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate.get();
    }

    public MedicineStock setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate.setValue(receivedDate);
        return this;
    }

    public LocalDate getExpDate() {
        return expDate.get();
    }

    public MedicineStock setExpDate(LocalDate expDate) {
        this.expDate.setValue(expDate);
        return this;
    }

    public BigDecimal getQtyToDosageFormMultiplier() {
        return qtyToDosageFormMultiplier.get();
    }

    public MedicineStock setQtyToDosageFormMultiplier(BigDecimal qtyToDosageFormMultiplier) {
        this.qtyToDosageFormMultiplier.setValue(qtyToDosageFormMultiplier);
        return this;
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

    public String getBatchNumber() {
        return batchNumber.get();
    }

    public MedicineStock setBatchNumber(String batchNumber) {
        this.batchNumber.setValue(batchNumber);
        return this;
    }

    @Override
    public MedicineStock copy(MedicineStock entity) {
        return this
            .setDosageFormId(entity.getDosageFormId())
            .setExpDate(entity.getExpDate())
            .setMedicineId(entity.getMedicineId())
            .setQtyAvailable(entity.getQtyAvailable())
            .setQtyUnitId(entity.getQtyUnitId())
            .setReceivedDate(entity.getReceivedDate())
            .setBatchNumber(entity.getBatchNumber())
            .setQtyToDosageFormMultiplier(entity.getQtyToDosageFormMultiplier());
    }
}
