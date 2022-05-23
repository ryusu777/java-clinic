package com.clinic.doctor.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class CheckUpDetail extends AbstractEntity implements ICopyable <CheckUpDetail> {

    public CheckUpDetail(){
        this(null);
    }

    public CheckUpDetail(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "check_up_category_id",
            "medical_record_id",
            "check_up_result"
        );
    }

    private IntegerProperty checkUpCategoryId = new SimpleIntegerProperty();
    private IntegerProperty medicalRecordId = new SimpleIntegerProperty();
    private StringProperty checkUpResult = new SimpleStringProperty();

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

    private MedicalRecord medicalRecord = new MedicalRecord();

    public MedicalRecord getMedicalRecord() {
        return medicalRecord;
    }

    public CheckUpDetail setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
        return this;
    }

    private CheckUpCategory checkUpCategory = new CheckUpCategory();

    public CheckUpCategory getCheckUpCategory() {
        return checkUpCategory;
    }

    public CheckUpDetail setCheckUpCategory(CheckUpCategory checkUpCategory) {
        this.checkUpCategory = checkUpCategory;
        return this;
    }


    @Override
    public CheckUpDetail copy(CheckUpDetail entity) {
        return this
            .setCheckUpCategoryId(entity.getCheckUpCategoryId())
            .setMedicalRecordId(entity.getMedicalRecordId())
            .setCheckUpResult(entity.getCheckUpResult());
    } 
}
