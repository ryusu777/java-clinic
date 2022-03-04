package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.PurchaseMedicineHeader;

public class PurchaseMedicineHeaderRepository extends AbstractEntityRepository<PurchaseMedicineHeader> {
    protected PurchaseMedicineHeaderRepository() {
        super(PurchaseMedicineHeader.class);
    }

    @Override
    protected String tableName() {
        return "purchase_medicine_header";
    }
}
