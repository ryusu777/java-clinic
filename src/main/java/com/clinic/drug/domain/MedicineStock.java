package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "received_date",
            "exp_date",
            "qty_available",
            "qty_to_dosage_form_multiplier",
            "medicine_id",
            "batch_number",
            "dosage_form_id",
            "qty_unit_id",
            "purchase_medicine_detail_id",
            "highest_retail_price"
        );
    }
    
    private ObjectProperty<LocalDateTime> receivedDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDateTime> receivedDateProperty() {
        return this.receivedDate;
    }

    public LocalDateTime getReceivedDate() {
        return receivedDate.get();
    }

    public MedicineStock setReceivedDate(LocalDateTime receivedDate) {
        this.receivedDate.setValue(receivedDate);
        return this;
    }

    private ObjectProperty<LocalDate> expDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> expDateProperty() {
        return this.expDate;
    }

    public LocalDate getExpDate() {
        return expDate.get();
    }

    public MedicineStock setExpDate(LocalDate expDate) {
        this.expDate.setValue(expDate);
        return this;
    }

    private ObjectProperty<BigDecimal> qtyAvailable = new SimpleObjectProperty<>();
    public ObjectProperty<BigDecimal> qtyAvailableProperty() {
        return this.qtyAvailable;
    }

    public BigDecimal getQtyAvailable() {
        return qtyAvailable.get();
    }

    public MedicineStock setQtyAvailable(BigDecimal qtyAvailable) {
        this.qtyAvailable.setValue(qtyAvailable);
        return this;
    }

    private ObjectProperty<BigDecimal> qtyToDosageFormMultiplier = new SimpleObjectProperty<>();
    public ObjectProperty<BigDecimal> qtyToDosageFormMultiplierProperty() {
        return this.qtyToDosageFormMultiplier;
    }

    public BigDecimal getQtyToDosageFormMultiplier() {
        return qtyToDosageFormMultiplier.get();
    }

    public MedicineStock setQtyToDosageFormMultiplier(BigDecimal qtyToDosageFormMultiplier) {
        this.qtyToDosageFormMultiplier.setValue(qtyToDosageFormMultiplier);
        return this;
    }

    private IntegerProperty medicineId = new SimpleIntegerProperty();
    public IntegerProperty medicineIdProperty() {
        return this.medicineId;
    }

    public Integer getMedicineId() {
        return medicineId.get();
    }

    public MedicineStock setMedicineId(Integer medicineId) {
        this.medicineId.setValue(medicineId);
        return this;
    }

    private StringProperty batchNumber = new SimpleStringProperty();
    public StringProperty batchNumberProperty() {
        return batchNumber;
    }

    public String getBatchNumber() {
        return batchNumber.get();
    }

    public MedicineStock setBatchNumber(String batchNumber) {
        this.batchNumber.setValue(batchNumber);
        return this;
    }

    private IntegerProperty dosageFormId = new SimpleIntegerProperty();
    public IntegerProperty dosageFormIdProperty() {
        return this.dosageFormId;
    }

    public Integer getDosageFormId() {
        return dosageFormId.get();
    }

    public MedicineStock setDosageFormId(Integer dosageFormId) {
        this.dosageFormId.setValue(dosageFormId);
        return this;
    }

    private IntegerProperty qtyUnitId = new SimpleIntegerProperty();
    public IntegerProperty qtyUnitIdProperty() {
        return this.qtyUnitId;
    }

    public Integer getQtyUnitId() {
        return qtyUnitId.get();
    }

    public MedicineStock setQtyUnitId(Integer qtyUnitId) {
        this.qtyUnitId.setValue(qtyUnitId);
        return this;
    }

    private IntegerProperty purchaseMedicineDetailId = new SimpleIntegerProperty();
    public IntegerProperty purchaseMedicineDetailIdProperty() {
        return this.purchaseMedicineDetailId;
    }

    public Integer getPurchaseMedicineDetailId() {
        return purchaseMedicineDetailId.get();
    }

    public MedicineStock setPurchaseMedicineDetailId(Integer purchaseMedicineDetailId) {
        this.purchaseMedicineDetailId.setValue(purchaseMedicineDetailId);
        return this;
    }

    private IntegerProperty highestRetailPrice = new SimpleIntegerProperty();
    public IntegerProperty highestRetailPriceProperty() {
        return this.highestRetailPrice;
    }

    public Integer getHighestRetailPrice() {
        return highestRetailPrice.get();
    }

    public MedicineStock setHighestRetailPrice(Integer highestRetailPrice) {
        this.highestRetailPrice.setValue(highestRetailPrice);
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
            .setQtyToDosageFormMultiplier(entity.getQtyToDosageFormMultiplier())
            .setHighestRetailPrice(entity.getHighestRetailPrice())
            .setPurchaseMedicineDetailId(entity.getPurchaseMedicineDetailId());
    }
}
