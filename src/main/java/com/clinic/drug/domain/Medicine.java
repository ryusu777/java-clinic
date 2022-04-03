package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicine extends AbstractEntity {
    public Medicine(Integer id) {
        super(id);
        brandName = new SimpleStringProperty();
        genericName = new SimpleStringProperty();
    }

    public Medicine() {
        this(null);
    }

    private StringProperty brandName, genericName;
    
    public StringProperty brandNameProperty() {
        return brandName;
    }

    public StringProperty genericNameProperty() {
        return genericName;
    }

    public String getBrandName() {
        return brandName.get();
    }

    public Medicine setBrandName(String brandName) {
        this.brandName.setValue(brandName);
        return this;
    }

    public String getGenericName() {
        return genericName.get();
    }

    public Medicine setGenericName(String genericName) {
        this.genericName.setValue(genericName);
        return this;
    }
}
