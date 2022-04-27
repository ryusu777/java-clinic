package com.clinic.drug.domain;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SellMedicineDetail extends AbstractEntity implements Copyable<SellMedicineDetail> {
    public SellMedicineDetail() {
        this(null);
    }

    public SellMedicineDetail(Integer id) {
        super(id);
    }
    
    private IntegerProperty price = new SimpleIntegerProperty();
    public IntegerProperty pricePropery() {
        return price;
    }

    public Integer getPrice() {
        return price.get();
    }

    public SellMedicineDetail setPrice(Integer price) {
        this.price.setValue(price);
        return this;
    }

    private IntegerProperty sellMedicineHeaderId = new SimpleIntegerProperty();
    public IntegerProperty sellMedicineHeaderIdPropery() {
        return sellMedicineHeaderId;
    }

    public Integer getSellMedicineHeaderId() {
        return sellMedicineHeaderId.get();
    }

    public SellMedicineDetail setSellMedicineHeaderId(Integer sellMedicineHeaderId) {
        this.sellMedicineHeaderId.setValue(sellMedicineHeaderId);
        return this;
    }

    private IntegerProperty prescriptionRecipeId = new SimpleIntegerProperty();
    public IntegerProperty prescriptionRecipeIdPropery() {
        return prescriptionRecipeId;
    }

    public Integer getPrescriptionRecipeId() {
        return prescriptionRecipeId.get();
    }

    public SellMedicineDetail setPrescriptionRecipeId(Integer medicineStockId) {
        this.prescriptionRecipeId.setValue(medicineStockId);
        return this;
    }

    public IntegerProperty medicineStockId = new SimpleIntegerProperty();
    public IntegerProperty medicineStockIdPropery() {
        return medicineStockId;
    }

    public Integer getMedicineStockId() {
        return medicineStockId.get();
    }

    public SellMedicineDetail setMedicineStockId(Integer medicineStockId) {
        this.medicineStockId.setValue(medicineStockId);
        return this;
    }

    @Override
    public SellMedicineDetail copy(SellMedicineDetail entity) {
        return this
            .setPrescriptionRecipeId(entity.getPrescriptionRecipeId())
            .setPrice(entity.getPrice())
            .setSellMedicineHeaderId(entity.getSellMedicineHeaderId())
            .setMedicineStockId(entity.getMedicineStockId());
    }
}
