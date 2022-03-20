package com.clinic.drug.domain;

import java.sql.Date;

import com.clinic.AbstractEntity;

public class SellMedicineHeader extends AbstractEntity {
    public SellMedicineHeader() {
        super(null);
    }

    public SellMedicineHeader(Integer id) {
        super(id);
    }
    
    private Date purchaseDate;
    private Integer prescriptionHeaderId;

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId;
    }

    public SellMedicineHeader setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId = prescriptionHeaderId;
        return this;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public SellMedicineHeader setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
        return this;
    }
}
