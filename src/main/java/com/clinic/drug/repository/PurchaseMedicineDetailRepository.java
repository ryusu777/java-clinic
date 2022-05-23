package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.PurchaseMedicineDetail;

public class PurchaseMedicineDetailRepository extends AbstractEntityRepository<PurchaseMedicineDetail> {
    public PurchaseMedicineDetailRepository() {
        super(PurchaseMedicineDetail.class);
    }

    @Override
    protected String tableName() {
        return "purchase_medicine_detail";
    }
}
