package com.clinic.doctor.domain;

import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import com.clinic.abstracts.AbstractEntity;

public class CheckUpDetail extends AbstractEntity {

    public CheckUpDetail(Integer id) {
        super(id);
    }

    public CheckUpDetail() {
        super(null);
    }
    
    private Integer id, checkUpCategoryId, medicalRecordId;
    private String checkUpResult;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "id",
            "check_up_category_id",
            "medical_record_id",
            "check_up_result");
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCheckUpCategoryId(Integer checkUpCategoryId) {
        this.checkUpCategoryId = checkUpCategoryId; 
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }

    public void setCheckUpResult(String checkUpResult) {
        this.checkUpResult = checkUpResult;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCheckUpCategoryId() {
        return checkUpCategoryId;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public String getCheckUpResult() {
        return checkUpResult;
    }
}
