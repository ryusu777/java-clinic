package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class DosageFormCategory extends AbstractEntity {
    public DosageFormCategory() {
        super(null);
    }

    public DosageFormCategory(Integer id) {
        super(id);
    }

    private String name;

    public DosageFormCategory setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }
}
