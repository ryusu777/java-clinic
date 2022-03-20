package com.clinic.drug.domain;

import com.clinic.AbstractEntity;

public class PrescriptionQueue extends AbstractEntity {
    public PrescriptionQueue() {
        super(null);
    }

    public PrescriptionQueue(Integer id) {
        super(id);
    }
    
    public static final int WAITING_TO_MAKE = 1,
        MAKING = 2,
        WAITING_TO_PATIENT = 3,
        DONE = 4;

    private Integer status, prescriptionHeaderId;

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId;
    }

    public PrescriptionQueue setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId = prescriptionHeaderId;
        return this;
    }

    public Integer getStatus() {
        return status;
    }

    public PrescriptionQueue setStatus(Integer status) {
        this.status = status;
        return this;
    }
}
