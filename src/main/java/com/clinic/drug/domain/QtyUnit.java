package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class QtyUnit extends AbstractEntity {
    public QtyUnit() {
        super(null);
    }

    public QtyUnit(Integer id) {
        super(id);
    }
    
    private String name, shortName;

    public String getShortName() {
        return shortName;
    }

    public QtyUnit setShortName(String shortName) {
        this.shortName = shortName;
        return this;
    }

    public String getName() {
        return name;
    }

    public QtyUnit setName(String name) {
        this.name = name;
        return this;
    }
}
