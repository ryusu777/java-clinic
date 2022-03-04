package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.PurchaseMedicineDetail;

public class PurchaseMedicineDetailRepository extends AbstractEntityRepository<PurchaseMedicineDetail> {
    protected PurchaseMedicineDetailRepository() {
        super(PurchaseMedicineDetail.class);
    }

    @Override
    protected String tableName() {
        return "purchase_medicine_detail";
    }
}
