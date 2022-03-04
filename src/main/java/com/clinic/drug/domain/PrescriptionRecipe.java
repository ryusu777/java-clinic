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

    public void setUsageInstruction(String usageInstruction) {
        this.usageInstruction = usageInstruction;
    }

    public String getLatinUsageInstruction() {
        return latinUsageInstruction;
    }

    public void setLatinUsageInstruction(String latinUsageInstruction) {
        this.latinUsageInstruction = latinUsageInstruction;
    }

    public String getLatinMakingInstruction() {
        return latinMakingInstruction;
    }

    public void setLatinMakingInstruction(String latinMakingInstruction) {
        this.latinMakingInstruction = latinMakingInstruction;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Integer getDosageFormId() {
        return dosageFormId;
    }

    public void setDosageFormId(Integer dosageFormId) {
        this.dosageFormId = dosageFormId;
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId;
    }

    public void setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId = prescriptionHeaderId;
    }
    
}
