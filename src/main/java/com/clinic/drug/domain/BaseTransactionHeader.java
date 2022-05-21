package com.clinic.drug.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class BaseTransactionHeader extends AbstractEntity {
    public BaseTransactionHeader(Integer id) {
        super(id);
    }

    public BaseTransactionHeader() {
        this(null);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "purchase_date"
        );
    }
    
    private ObjectProperty<LocalDate> purchaseDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> purchaseDateProperty() {
        return purchaseDate;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate.get();
    }

    public BaseTransactionHeader setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate.setValue(purchaseDate);
        return this;
    }
}
