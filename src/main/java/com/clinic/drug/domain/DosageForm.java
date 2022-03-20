package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class DosageForm extends AbstractEntity {
    public DosageForm() {
        super(null);
    }

    public DosageForm(Integer id) {
        super(id);
    }
    
    private String name;
    private Integer dosageFormCategoryId;
    
    public String getName() {
        return name;
    }

    public DosageForm setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getDosageFormCategoryId() {
        return dosageFormCategoryId;
    }

    public DosageForm setDosageFormCategoryId(Integer dosageFormCategoryId) {
        this.dosageFormCategoryId = dosageFormCategoryId;
        return this;
    }
}
