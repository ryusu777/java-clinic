package com.clinic.drug.domain;

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
        name = new SimpleStringProperty();
        shortName = new SimpleStringProperty();
    }
    
    private StringProperty name, shortName;

    public StringProperty nameProperty() {
        return name;
    }

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

    public String getName() {
        return name.get();
    }

    public QtyUnit setName(String name) {
        this.name.setValue(name);
        return this;
    }

    @Override
    public QtyUnit copy(QtyUnit entity) {
        return this
            .setName(entity.getName())
            .setShortName(entity.getShortName());
    }
}
