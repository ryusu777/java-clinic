package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.PrescriptionQueue;

public class PrescriptionQueueRepository extends AbstractEntityRepository<PrescriptionQueue> {
    public PrescriptionQueueRepository() {
        super(PrescriptionQueue.class);
    }

    @Override
    protected String tableName() {
        return "prescription_queue";
    }
}
