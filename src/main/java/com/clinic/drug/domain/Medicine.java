package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;

public class Medicine extends AbstractEntity {
    public Medicine(Integer id) {
        super(id);
    }

    public Medicine() {
        super(null);
    }

    private Integer dosageFormId, qtyUnitId;
    private String brandName, genericName;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "brand_name",
                "generic_name",
                "dosage_form_id",
                "qty_unit_id");
    }

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
