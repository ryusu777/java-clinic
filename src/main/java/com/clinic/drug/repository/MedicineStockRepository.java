package com.clinic.drug.repository;

import com.clinic.AbstractEntityRepository;
import com.clinic.drug.domain.MedicineStock;

public class MedicineStockRepository extends AbstractEntityRepository<MedicineStock> {
    protected MedicineStockRepository() {
        super(MedicineStock.class);
    }

    @Override
    protected String tableName() {
        return "medicine_stock";
    }
    
}
