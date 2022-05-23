package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MedicineRequest extends AbstractEntity implements ICopyable<MedicineRequest> {
    public final static int NOT_AVAILABLE = 0, AVAILABLE = 1;
    public MedicineRequest() {
        this(null);
    }

    public MedicineRequest(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "brand_name",
            "generic_name",
            "status"
        );
    }
    
    private StringProperty brandName = new SimpleStringProperty();
    public StringProperty brandNameProperty() {
        return brandName;
    }

    public String getBrandName() {
        return brandName.get();
    }

    public MedicineRequest setBrandName(String brandName) {
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

    public MedicineRequest setGenericName(String genericName) {
        this.genericName.setValue(genericName);
        return this;
    }

    private IntegerProperty status = new SimpleIntegerProperty();
    public IntegerProperty statusProperty() {
        return status;
    }

    public Integer getStatus() {
        return status.get();
    }

    public MedicineRequest setStatus(Integer status) {
        this.status.setValue(status);
        return this;
    }

    @Override
    public MedicineRequest copy(MedicineRequest entity) {
        return this
            .setGenericName(entity.getGenericName())
            .setBrandName(entity.getBrandName())
            .setStatus(entity.getStatus());
    }
}
