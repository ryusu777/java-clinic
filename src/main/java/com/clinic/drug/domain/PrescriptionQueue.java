package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PrescriptionQueue extends AbstractEntity implements ICopyable<PrescriptionQueue> {
    public PrescriptionQueue() {
        this(null);
    }

    public PrescriptionQueue(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "status",
            "prescription_header_id"
        );
    }
    
    public static final int WAITING_TO_MAKE = 1,
        MAKING = 2,
        WAITING_TO_PATIENT = 3,
        DONE = 4;

    private IntegerProperty status = new SimpleIntegerProperty();
    public IntegerProperty statusProperty() {
        return this.status;
    }

    public Integer getStatus() {
        return status.get();
    }

    public PrescriptionQueue setStatus(Integer status) {
        this.status.setValue(status);
        return this;
    }

    private IntegerProperty prescriptionHeaderId = new SimpleIntegerProperty();
    public IntegerProperty prescriptionHeaderIdProperty() {
        return this.prescriptionHeaderId;
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId.get();
    }

    public PrescriptionQueue setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId.setValue(prescriptionHeaderId);
        return this;
    }

    @Override
    public PrescriptionQueue copy(PrescriptionQueue entity) {
        return this
            .setPrescriptionHeaderId(entity.getPrescriptionHeaderId())
            .setStatus(entity.getStatus());
    }
}
