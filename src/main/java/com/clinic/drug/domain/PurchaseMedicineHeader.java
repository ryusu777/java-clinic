package com.clinic.drug.domain;

import java.time.LocalDate;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PurchaseMedicineHeader extends AbstractEntity implements Copyable<PurchaseMedicineHeader> {
    public PurchaseMedicineHeader() {
        this(null);
    }

    public PurchaseMedicineHeader(Integer id) {
        super(id);
    }
    
    private ObjectProperty<LocalDate> purchaseDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> purchaseDateProperty() {
        return purchaseDate;
    };

    public LocalDate getPurchaseDate() {
        return purchaseDate.get();
    }

    public PurchaseMedicineHeader setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate.setValue(purchaseDate);
        return this;
    }

    @Override
    public PurchaseMedicineHeader copy(PurchaseMedicineHeader entity) {
        return this
            .setPurchaseDate(entity.getPurchaseDate());
    }
}
