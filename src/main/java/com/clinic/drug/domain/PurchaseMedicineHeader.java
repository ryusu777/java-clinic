package com.clinic.drug.domain;

import java.sql.Date;

import com.clinic.AbstractEntity;

public class PurchaseMedicineHeader extends AbstractEntity {
    public PurchaseMedicineHeader() {
        super(null);
    }

    public PurchaseMedicineHeader(Integer id) {
        super(id);
    }
    
    private Date purchaseDate;

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
