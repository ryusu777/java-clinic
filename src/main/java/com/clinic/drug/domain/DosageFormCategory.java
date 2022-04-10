package com.clinic.drug.domain;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DosageFormCategory extends AbstractEntity implements Copyable<DosageFormCategory> {
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

    @Override
    public DosageFormCategory copy(DosageFormCategory entity) {
        return this
            .setName(entity.getName());
    }
}
