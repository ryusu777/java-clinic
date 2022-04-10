package com.clinic.drug.domain;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class PrescriptionQueue extends AbstractEntity implements Copyable<PrescriptionQueue> {
    public PrescriptionQueue() {
        this(null);
    }

    public PrescriptionQueue(Integer id) {
        super(id);
        status = new SimpleIntegerProperty();
        prescriptionHeaderId = new SimpleIntegerProperty();
    }
    
    public static final int WAITING_TO_MAKE = 1,
        MAKING = 2,
        WAITING_TO_PATIENT = 3,
        DONE = 4;

    private IntegerProperty status, prescriptionHeaderId;

    public IntegerProperty statusProperty() {
        return this.status;
    }

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

    public Integer getStatus() {
        return status.get();
    }

    public PrescriptionQueue setStatus(Integer status) {
        this.status.setValue(status);
        return this;
    }

    @Override
    public PrescriptionQueue copy(PrescriptionQueue entity) {
        return this
            .setPrescriptionHeaderId(entity.getPrescriptionHeaderId())
            .setStatus(entity.getStatus());
    }
}
