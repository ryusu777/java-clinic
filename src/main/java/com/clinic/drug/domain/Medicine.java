package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;

public class Medicine extends AbstractEntity {
    public Medicine(Integer id) {
        super(id);
    }

    public Medicine() {
        super(null);
    }

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

    public Medicine setBrandName(String brandName) {
        this.brandName = brandName;
        return this;
    }

    public String getGenericName() {
        return genericName;
    }

    public Medicine setGenericName(String genericName) {
        this.genericName = genericName;
        return this;
    }
}
