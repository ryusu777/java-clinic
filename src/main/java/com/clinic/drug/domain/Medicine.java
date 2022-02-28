package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class Medicine extends AbstractEntity {
    public Medicine(Integer id) {
        super(id);
    }

    public Medicine() {
        super(null);
    }

    private Integer dosageFormId, qtyUnitId;
    private String brandName, genericName;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public Integer getDosageFormId() {
        return dosageFormId;
    }

    public void setDosageFormId(Integer dosageFormId) {
        this.dosageFormId = dosageFormId;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public Integer getQtyUnitId() {
        return qtyUnitId;
    }

    public void setQtyUnitId(Integer qtyUnitId) {
        this.qtyUnitId = qtyUnitId;
    }
}
