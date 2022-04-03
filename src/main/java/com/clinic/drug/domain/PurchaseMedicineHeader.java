package com.clinic.drug.domain;

import java.sql.Date;

import com.clinic.AbstractEntity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PurchaseMedicineHeader extends AbstractEntity {
    public PurchaseMedicineHeader() {
        this(null);
    }

    public PurchaseMedicineHeader(Integer id) {
        super(id);
        purchaseDate = new SimpleObjectProperty<>();
    }
    
    private ObjectProperty<Date> purchaseDate;

    public Date getPurchaseDate() {
        return purchaseDate.get();
    }

    public PurchaseMedicineHeader setPurchaseDate(Date purchaseDate) {
        this.purchaseDate.setValue(purchaseDate);
        return this;
    }
}
