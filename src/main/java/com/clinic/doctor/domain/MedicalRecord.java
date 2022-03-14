package com.clinic.doctor.domain;

import java.util.Arrays;
import java.util.List;
import java.sql.Date;
import java.time.LocalDate;

import com.clinic.AbstractEntity;

public class MedicalRecord extends AbstractEntity {

    public MedicalRecord(Integer id) {
        super(id);
    }

    public MedicalRecord() {
        super(null);
    }
    
    private Integer patientId, doctorId;
    private String symptom, treatment, prescriptionHeaderId;
    private Date checkUpDate;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "patient_id",
            "check_up_date",
            "symptom",
            "treatment",
            "prescription_header_id",
            "doctor_id");
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void setCheckUpDate(Date checkUpDate) {
        this.checkUpDate = checkUpDate; 
    }

    public void setSymptom(String symptom) {
        this.symptom = symptom;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setPrescriptionHeaderId(String prescriptionHeaderId) {
        this.prescriptionHeaderId = prescriptionHeaderId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public Date getCheckUpDate() {
        return checkUpDate;
    }

    public String getSymptom() {
        return symptom;
    }

    public String getTreatment() {
        return treatment;
    }

    public String getPrescriptionHeaderId() {
        return prescriptionHeaderId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }
}
