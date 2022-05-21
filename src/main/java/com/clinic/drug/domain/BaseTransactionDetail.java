package com.clinic.drug.domain;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class BaseTransactionDetail extends AbstractEntity {
    public final static int PURCHASE = 1, SELL = 2;
    public BaseTransactionDetail(Integer id) {
        super(id);
    }

    public BaseTransactionDetail() {
        this(null);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "price_per_unit",
            "qty"
        );
    }
    
    private IntegerProperty pricePerUnit = new SimpleIntegerProperty();
    public IntegerProperty pricePerUnitProperty() {
        return this.pricePerUnit;
    }

    public Integer getPricePerUnit() {
        return pricePerUnit.get();
    }

    public BaseTransactionDetail setPricePerUnit(Integer pricePerUnit) {
        this.pricePerUnit.setValue(pricePerUnit);
        return this;
    }

    private ObjectProperty<BigDecimal> qty = new SimpleObjectProperty<>();
    public ObjectProperty<BigDecimal> qtyProperty() {
        return this.qty;
    }

    public BigDecimal getQty() {
        return qty.get();
    }

    public BaseTransactionDetail setQty(BigDecimal qty) {
        this.qty.setValue(qty);
        return this;
    }
}
