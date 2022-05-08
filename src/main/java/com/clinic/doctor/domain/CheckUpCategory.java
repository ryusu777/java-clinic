package com.clinic.doctor.domain;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
public class CheckUpCategory extends AbstractEntity implements Copyable <CheckUpCategory> {
    public CheckUpCategory() {
        this(null);
    }

    public CheckUpCategory(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "category_name"
        );
    }

    private StringProperty categoryName = new SimpleStringProperty();

    public StringProperty categoryNameProperty() {
        return this.categoryName;
    }

    public CheckUpCategory setCategoryName(String categoryName) {
        this.categoryName.setValue(categoryName);
        return this;
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    @Override
    public CheckUpCategory copy(CheckUpCategory entity) {
        return this
            .setCategoryName(entity.getCategoryName());
    }
   
}
