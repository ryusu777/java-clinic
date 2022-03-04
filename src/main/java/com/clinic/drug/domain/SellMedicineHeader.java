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

    public void setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId = prescriptionHeaderId;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
