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

    public void setReceivedDate(Timestamp receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public BigDecimal getQtyAvailable() {
        return qtyAvailable;
    }

    public void setQtyAvailable(BigDecimal qtyAvailable) {
        this.qtyAvailable = qtyAvailable;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }
}
