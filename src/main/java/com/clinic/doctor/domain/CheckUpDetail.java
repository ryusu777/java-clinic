package com.clinic.doctor.domain;

import java.time.LocalDate;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CheckUpDetail extends AbstractEntity implements Copyable <CheckUpDetail> {

    public CheckUpDetail(){
        this(null);
    }

    public CheckUpDetail(Integer id) {
        super(id);
        checkUpCategoryId = new SimpleIntegerProperty();
        medicalRecordId = new SimpleIntegerProperty();
        checkUpResult = new SimpleStringProperty();
    }

    private IntegerProperty checkUpCategoryId, medicalRecordId;
    private StringProperty checkUpResult;

    public IntegerProperty checkUpCategoryIdProperty() {
        return this.checkUpCategoryId;
    }

    public IntegerProperty medicalRecordIdProperty() {
        return this.medicalRecordId;
    }

    public StringProperty checkUpResultProperty() {
        return this.checkUpResult;
    }
        
    public CheckUpDetail setCheckUpCategoryId(Integer checkUpCategoryId) {
        this.checkUpCategoryId.setValue(checkUpCategoryId);
        return this;
    } 

    public CheckUpDetail setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId.setValue(medicalRecordId);
        return this;
    }

    public CheckUpDetail setCheckUpResult(String checkUpResult) {
        this.checkUpResult.setValue(checkUpResult);
        return this;
    }

    public Integer getCheckUpCategoryId() {
        return checkUpCategoryId.get();
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId.get();
    }

    public String getCheckUpResult() {
        return checkUpResult.get();
    }


    @Override
    public CheckUpDetail copy(CheckUpDetail entity) {
        return this
            .setCheckUpCategoryId(entity.getCheckUpCategoryId())
            .setMedicalRecordId(entity.getMedicalRecordId())
            .setCheckUpResult(entity.getCheckUpResult());
    } 
}
