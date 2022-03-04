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

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDosageFormCategoryId() {
        return dosageFormCategoryId;
    }

    public void setDosageFormCategoryId(Integer dosageFormCategoryId) {
        this.dosageFormCategoryId = dosageFormCategoryId;
    }
}
