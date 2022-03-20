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

    public PrescriptionHeader setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
        return this;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public PrescriptionHeader setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
        return this;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public PrescriptionHeader setPatientId(Integer patientId) {
        this.patientId = patientId;
        return this;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId;
    }

    public PrescriptionHeader setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId = medicalRecordId;
        return this;
    }
}
