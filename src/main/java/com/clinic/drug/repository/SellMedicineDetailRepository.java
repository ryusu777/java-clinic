package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.SellMedicineDetail;

public class SellMedicineDetailRepository extends AbstractEntityRepository<SellMedicineDetail> {
    public SellMedicineDetailRepository() {
        super(SellMedicineDetail.class);
    }

    @Override
    protected String tableName() {
        return "sell_medicine_detail";
    }
}
