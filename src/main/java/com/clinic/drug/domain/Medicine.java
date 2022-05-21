package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Medicine extends AbstractEntity implements ICopyable<Medicine> {
    public Medicine(Integer id) {
        super(id);
    }

    public Medicine() {
        this(null);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "brand_name",
            "generic_name",
            "medicine_type"
        );
    }

    private StringProperty brandName = new SimpleStringProperty();
    
    public StringProperty brandNameProperty() {
        return brandName;
    }

    public String getBrandName() {
        return brandName.get();
    }

    public Medicine setBrandName(String brandName) {
        this.brandName.setValue(brandName);
        return this;
    }

    private StringProperty genericName = new SimpleStringProperty();
    public StringProperty genericNameProperty() {
        return genericName;
    }

    public String getGenericName() {
        return genericName.get();
    }

    public Medicine setGenericName(String genericName) {
        this.genericName.setValue(genericName);
        return this;
    }

    private StringProperty medicineType = new SimpleStringProperty();

    public StringProperty medicineTypeProperty() {
        return this.medicineType;
    }

    public String getMedicineType() {
        return medicineType.get();
    }

    public Medicine setMedicineType(String medicineType) {
        this.medicineType.setValue(medicineType);
        return this;
    }

    @Override
    public Medicine copy(Medicine entity) {
        return this
            .setBrandName(entity.getBrandName())
            .setGenericName(entity.getGenericName())
            .setMedicineType(entity.getMedicineType());
    }
}
