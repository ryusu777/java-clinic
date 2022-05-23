package com.clinic.drug.repository;

import com.clinic.abstracts.AbstractEntityRepository;
import com.clinic.drug.domain.MedicineStock;

public class MedicineStockRepository extends AbstractEntityRepository<MedicineStock> {
    public MedicineStockRepository() {
        super(MedicineStock.class);
    }

    @Override
    protected String tableName() {
        return "medicine_stock";
    }
    
}
