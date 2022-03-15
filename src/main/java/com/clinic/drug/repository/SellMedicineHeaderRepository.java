package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.SellMedicineHeader;

public class SellMedicineHeaderRepository extends AbstractEntityRepository<SellMedicineHeader> {
    public SellMedicineHeaderRepository() {
        super(SellMedicineHeader.class);
    }

    @Override
    protected String tableName() {
        return "sell_medicine_header";
    }
}
