package com.clinic.drug.domain;

import java.sql.Date;

import com.clinic.AbstractEntity;

public class PrescriptionHeader extends AbstractEntity {
    public PrescriptionHeader() {
        super(null);
    }

    public PrescriptionHeader(Integer id) {
        super(id);
    }
    
    private Date createdDate;
    private Integer doctorId, patientId, medicalRecordId;

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public void setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
    }
}
