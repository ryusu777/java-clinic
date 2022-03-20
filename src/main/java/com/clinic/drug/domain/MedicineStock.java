package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;

import com.clinic.AbstractEntity;

public class MedicineStock extends AbstractEntity {
    public MedicineStock() {
        super(null);
    }

    public MedicineStock(Integer id) {
        super(id);
    }
    
    private Timestamp receivedDate;
    private Date expDate;
    private BigDecimal qtyAvailable;
    private Integer medicineId;

    public Timestamp getReceivedDate() {
        return receivedDate;
    }

    public MedicineStock setReceivedDate(Timestamp receivedDate) {
        this.receivedDate = receivedDate;
        return this;
    }

    public Date getExpDate() {
        return expDate;
    }

    public MedicineStock setExpDate(Date expDate) {
        this.expDate = expDate;
        return this;
    }

    public BigDecimal getQtyAvailable() {
        return qtyAvailable;
    }

    public MedicineStock setQtyAvailable(BigDecimal qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
        return this;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public MedicineStock setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
        return this;
    }
}
