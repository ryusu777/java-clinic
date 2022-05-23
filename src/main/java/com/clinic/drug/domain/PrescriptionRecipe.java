package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class PrescriptionRecipe extends AbstractEntity implements ICopyable<PrescriptionRecipe> {
    public static final int COMPUND_TYPE = 0, GENERIC_TYPE = 1;

    public PrescriptionRecipe() {
        this(null);
    }

    public PrescriptionRecipe(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "usage_instruction",
            "recipe_type",
            "qty_unit_id",
            "latin_usage_instruction",
            "latin_making_instruction",
            "exp_date",
            "qty",
            "dosage_form_id",
            "prescription_header_id"
        );
    }
    
    private StringProperty usageInstruction = new SimpleStringProperty();
    public StringProperty usageInstructionProperty() { 
        return this.usageInstruction;
    }

    public String getUsageInstruction() {
        return usageInstruction.get();
    }

    public PrescriptionRecipe setUsageInstruction(String usageInstruction) {
        this.usageInstruction.setValue(usageInstruction);
        return this;
    }

    private StringProperty latinUsageInstruction = new SimpleStringProperty();
    public StringProperty latinUsageInstructionProperty() { 
        return this.latinUsageInstruction;
    }

    public String getLatinUsageInstruction() {
        return latinUsageInstruction.get();
    }

    public PrescriptionRecipe setLatinUsageInstruction(String latinUsageInstruction) {
        this.latinUsageInstruction.setValue(latinUsageInstruction);
        return this;
    }

    private StringProperty latinMakingInstruction = new SimpleStringProperty();
    public StringProperty latinMakingInstructionProperty() {
        return this.latinMakingInstruction;
    }

    public String getLatinMakingInstruction() {
        return latinMakingInstruction.get();
    }

    public PrescriptionRecipe setLatinMakingInstruction(String latinMakingInstruction) {
        this.latinMakingInstruction.setValue(latinMakingInstruction);
        return this;
    }

    private ObjectProperty<LocalDate> expDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> expDateProperty() {
        return this.expDate;
    }

    public LocalDate getExpDate() {
        return expDate.get();
    }

    public PrescriptionRecipe setExpDate(LocalDate expDate) {
        this.expDate.setValue(expDate);
        return this;
    }

    private ObjectProperty<BigDecimal> qty = new SimpleObjectProperty<>();
    public ObjectProperty<BigDecimal> qtyProperty() {
        return this.qty;
    }

    public BigDecimal getQty() {
        return qty.get();
    }

    public PrescriptionRecipe setQty(BigDecimal qty) {
        this.qty.setValue(qty);
        return this;
    }

    private IntegerProperty recipeType = new SimpleIntegerProperty();
    public IntegerProperty recipeTypeProperty() {
        return this.recipeType;
    }

    public Integer getRecipeType() {
        return recipeType.get();
    }

    public PrescriptionRecipe setRecipeType(Integer recipeType) {
        this.recipeType.setValue(recipeType);
        return this;
    }

    private IntegerProperty dosageFormId = new SimpleIntegerProperty();
    public IntegerProperty dosageFormIdProperty() {
        return this.dosageFormId;
    }

    public Integer getDosageFormId() {
        return dosageFormId.get();
    }

    public PrescriptionRecipe setDosageFormId(Integer dosageFormId) {
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

    public PrescriptionRecipe setQtyUnitId(Integer qtyUnitId) {
        this.dosageFormId.setValue(qtyUnitId);
        return this;
    }

    private IntegerProperty prescriptionHeaderId = new SimpleIntegerProperty();
    public IntegerProperty prescriptionHeaderIdProperty() {
        return this.prescriptionHeaderId;
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId.get();
    }

    public PrescriptionRecipe setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId.setValue(prescriptionHeaderId);
        return this;
    }

    @Override
    public PrescriptionRecipe copy(PrescriptionRecipe entity) {
        return this
            .setDosageFormId(entity.getDosageFormId())
            .setExpDate(entity.getExpDate())
            .setLatinMakingInstruction(entity.getLatinMakingInstruction())
            .setLatinUsageInstruction(entity.getLatinUsageInstruction())
            .setPrescriptionHeaderId(entity.getPrescriptionHeaderId())
            .setQty(entity.getQty())
            .setUsageInstruction(entity.getUsageInstruction());
    }
}
