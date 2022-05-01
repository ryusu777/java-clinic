package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class QtyUnit extends AbstractEntity implements Copyable<QtyUnit> {
    public QtyUnit() {
        this(null);
    }

    public QtyUnit(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "name",
            "short_name"
        );
    }
    
    private StringProperty name = new SimpleStringProperty();
    public StringProperty nameProperty() {
        return name;
    }

    public String getName() {
        return name.get();
    }

    public QtyUnit setName(String name) {
        this.name.setValue(name);
        return this;
    }

    private StringProperty shortName = new SimpleStringProperty();
    public StringProperty shortNameProperty() {
        return shortName;
    }

    public String getShortName() {
        return shortName.get();
    }

    public QtyUnit setShortName(String shortName) {
        this.shortName.setValue(shortName);
        return this;
    }

    @Override
    public QtyUnit copy(QtyUnit entity) {
        return this
            .setName(entity.getName())
            .setShortName(entity.getShortName());
    }
}
