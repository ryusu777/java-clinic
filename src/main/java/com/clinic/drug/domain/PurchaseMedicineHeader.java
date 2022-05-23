package com.clinic.drug.domain;

import com.clinic.interfaces.ICopyable;

public class PurchaseMedicineHeader extends BaseTransactionHeader implements ICopyable<PurchaseMedicineHeader> {
    public PurchaseMedicineHeader() {
        this(null);
    }

    public PurchaseMedicineHeader(Integer id) {
        super(id);
    }
    
    @Override
    public PurchaseMedicineHeader copy(PurchaseMedicineHeader entity) {
        return (PurchaseMedicineHeader) this
            .setPurchaseDate(entity.getPurchaseDate());
    }
}
