package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DosageForm extends AbstractEntity {
    public DosageForm() {
        this(null);
    }

    public DosageForm(Integer id) {
        super(id);
        name = new SimpleStringProperty();
        dosageFormCategoryId = new SimpleIntegerProperty();
    }
    
    private StringProperty name;
    private IntegerProperty dosageFormCategoryId;

    public StringProperty nameProperty() {
        return this.name;
    }

    public IntegerProperty dosageFormCategoryIdProperty() {
        return this.dosageFormCategoryId;
    }

    public String getName() {
        return name.get();
    }

    public DosageForm setName(String name) {
        this.name.setValue(name);
        return this;
    }

    public Integer getDosageFormCategoryId() {
        return dosageFormCategoryId.get();
    }

    public DosageForm setDosageFormCategoryId(Integer dosageFormCategoryId) {
        this.dosageFormCategoryId.setValue(dosageFormCategoryId);
        return this;
    }
}
