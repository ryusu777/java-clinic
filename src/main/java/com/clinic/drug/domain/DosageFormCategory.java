package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DosageFormCategory extends AbstractEntity implements ICopyable<DosageFormCategory> {
    public DosageFormCategory() {
        this(null);
    }

    public DosageFormCategory(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "name"
        );
    }

    private StringProperty name = new SimpleStringProperty();
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
