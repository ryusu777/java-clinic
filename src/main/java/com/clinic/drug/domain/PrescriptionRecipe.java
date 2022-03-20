package com.clinic.drug.domain;

import java.sql.Date;

import com.clinic.AbstractEntity;

public class PrescriptionRecipe extends AbstractEntity {
    public PrescriptionRecipe() {
        super(null);
    }

    public PrescriptionRecipe(Integer id) {
        super(id);
    }
    
    private String usageInstruction, latinUsageInstruction, latinMakingInstruction;
    private Date expDate;
    private Integer qty, dosageFormId, prescriptionHeaderId;

    public String getUsageInstruction() {
        return usageInstruction;
    }

    public PrescriptionRecipe setUsageInstruction(String usageInstruction) {
        this.usageInstruction = usageInstruction;
        return this;
    }

    public String getLatinUsageInstruction() {
        return latinUsageInstruction;
    }

    public PrescriptionRecipe setLatinUsageInstruction(String latinUsageInstruction) {
        this.latinUsageInstruction = latinUsageInstruction;
        return this;
    }

    public String getLatinMakingInstruction() {
        return latinMakingInstruction;
    }

    public PrescriptionRecipe setLatinMakingInstruction(String latinMakingInstruction) {
        this.latinMakingInstruction = latinMakingInstruction;
        return this;
    }

    public Date getExpDate() {
        return expDate;
    }

    public PrescriptionRecipe setExpDate(Date expDate) {
        this.expDate = expDate;
        return this;
    }

    public Integer getQty() {
        return qty;
    }

    public PrescriptionRecipe setQty(Integer qty) {
        this.qty = qty;
        return this;
    }

    public Integer getDosageFormId() {
        return dosageFormId;
    }

    public PrescriptionRecipe setDosageFormId(Integer dosageFormId) {
        this.dosageFormId = dosageFormId;
        return this;
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId;
    }

    public PrescriptionRecipe setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId = prescriptionHeaderId;
        return this;
    }
}
