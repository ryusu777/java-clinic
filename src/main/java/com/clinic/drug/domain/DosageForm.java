package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DosageForm extends AbstractEntity implements ICopyable<DosageForm> {
    public DosageForm() {
        this(null);
    }

    public DosageForm(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "name",
            "dosage_form_category_id"
        );
    }

    private StringProperty name = new SimpleStringProperty();
    public StringProperty nameProperty() {
        return this.name;
    }

    public String getName() {
        return name.get();
    }

    public DosageForm setName(String name) {
        this.name.setValue(name);
        return this;
    }

    private IntegerProperty dosageFormCategoryId = new SimpleIntegerProperty();
    public IntegerProperty dosageFormCategoryIdProperty() {
        return this.dosageFormCategoryId;
    }

    public Integer getDosageFormCategoryId() {
        return dosageFormCategoryId.get();
    }

    public DosageForm setDosageFormCategoryId(Integer dosageFormCategoryId) {
        this.dosageFormCategoryId.setValue(dosageFormCategoryId);
        return this;
    }

    private DosageFormCategory dosageFormCategory;
    public DosageFormCategory getDosageFormCategory() {
        return dosageFormCategory;
    }

    public DosageForm setDosageFormCategory(DosageFormCategory dosageFormCategory) {
        this.dosageFormCategory = dosageFormCategory;
        return this;
    }

    @Override
    public DosageForm copy(DosageForm entity) {
        return this
                .setName(entity.getName())
                .setDosageFormCategoryId(entity.getDosageFormCategoryId())
                .setDosageFormCategory(entity.getDosageFormCategory());
    }
}
