package com.clinic.drug.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class SellMedicineDetail extends BaseTransactionDetail implements ICopyable<SellMedicineDetail> {
    public SellMedicineDetail() {
        this(null);
    }

    public SellMedicineDetail(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        List<String> result = new ArrayList<>();
        result.addAll(super.getTableFieldNames());
        result.addAll(Arrays.asList(
            "sell_medicine_header_id",
            "prescription_recipe_id",
            "medicine_stock_id"
        ));
        return result;
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
        return (SellMedicineDetail) this
            .setPrescriptionRecipeId(entity.getPrescriptionRecipeId())
            .setSellMedicineHeaderId(entity.getSellMedicineHeaderId())
            .setMedicineStockId(entity.getMedicineStockId())
            .setQty(entity.getQty())
            .setPricePerUnit(entity.getPricePerUnit());
    }
}
