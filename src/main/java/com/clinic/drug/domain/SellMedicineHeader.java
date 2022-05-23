package com.clinic.drug.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SellMedicineHeader extends BaseTransactionHeader implements ICopyable<SellMedicineHeader> {
    public SellMedicineHeader() {
        this(null);
    }

    public SellMedicineHeader(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        List<String> result = new ArrayList<>();
        result.addAll(super.getTableFieldNames());
        result.addAll(Arrays.asList(
            "prescription_header_id"
        ));
        return result;
    }

    private IntegerProperty prescriptionHeaderId = new SimpleIntegerProperty();
    public IntegerProperty prescriptionHeaderIdProperty() {
        return prescriptionHeaderId;
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId.get();
    }

    public SellMedicineHeader setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId.setValue(prescriptionHeaderId);
        return this;
    }

    @Override
    public SellMedicineHeader copy(SellMedicineHeader entity) {
        return (SellMedicineHeader) this
            .setPrescriptionHeaderId(entity.getPrescriptionHeaderId())
            .setPurchaseDate(entity.getPurchaseDate());
    }
}
