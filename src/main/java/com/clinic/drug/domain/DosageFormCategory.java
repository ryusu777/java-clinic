package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DosageFormCategory extends AbstractEntity {
    public DosageFormCategory() {
        this(null);
    }

    public DosageFormCategory(Integer id) {
        super(id);
        name = new SimpleStringProperty();
    }

    private StringProperty name;

    public StringProperty nameProperty() {
        return this.name;
    }

    public DosageFormCategory setName(String name) {
        this.name.setValue(name);
        return this;
    }

    public String getName() {
        return name.get();
    }
}
