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
public class MedicalRecord extends AbstractEntity implements Copyable <MedicalRecord> {
    public MedicalRecord() {
        this(null);
    }

    public MedicalRecord(Integer id) {
        super(id);
        patientId = new SimpleIntegerProperty();
        doctorId = new SimpleIntegerProperty();
        prescriptionHeaderId = new SimpleIntegerProperty();
        symptom = new SimpleStringProperty();
        treatment = new SimpleStringProperty();
        checkUpDate = new SimpleObjectProperty<>();
    }
    
    private IntegerProperty patientId, doctorId, prescriptionHeaderId;
    private StringProperty symptom, treatment;
    private ObjectProperty<LocalDate> checkUpDate;

    public IntegerProperty patientIdProperty() {
        return this.patientId;
    }

    public IntegerProperty doctorIdProperty() {
        return this.doctorId;
    }

    public IntegerProperty prescriptionHeaderIdProperty() {
        return this.prescriptionHeaderId;
    }
    public StringProperty symptomProperty() {
        return this.symptom;
    }

    public StringProperty treatmentProperty() {
        return this.treatment;
    }

    public ObjectProperty<LocalDate> checkUpDateProperty() {
        return this.checkUpDate;
    }




    public MedicalRecord setPatientId(Integer patientId) {
        this.patientId.setValue(patientId);
        return this;
    }

    public MedicalRecord setCheckUpDate(LocalDate checkUpDate) {
        this.checkUpDate.setValue(checkUpDate); 
        return this;
    }

    public MedicalRecord setSymptom(String symptom) {
        this.symptom.setValue(symptom);
        return this;
    }

    public MedicalRecord setTreatment(String treatment) {
        this.treatment.setValue(treatment);
        return this;
    }

    public MedicalRecord setPrescriptionHeaderId(Integer prescriptionHeaderId) {
        this.prescriptionHeaderId.setValue(prescriptionHeaderId);
        return this;
    }

    public MedicalRecord setDoctorId(Integer doctorId) {
        this.doctorId.setValue(doctorId);
        return this;
    }

    public Integer getPatientId() {
        return patientId.get();
    }

    public LocalDate getCheckUpDate() {
        return checkUpDate.get();
    }

    public String getSymptom() {
        return symptom.get();
    }

    public String getTreatment() {
        return treatment.get();
    }

    public Integer getPrescriptionHeaderId() {
        return prescriptionHeaderId.get();
    }

    public Integer getDoctorId() {
        return doctorId.get();
    }

    @Override
    public MedicalRecord copy(MedicalRecord entity) {
        return this
            .setSymptom(entity.getSymptom())
            .setTreatment(entity.getTreatment())
            .setPrescriptionHeaderId(entity.getPrescriptionHeaderId())
            .setCheckUpDate(entity.getCheckUpDate())
            .setPatientId(entity.getPatientId())
            .setDoctorId(entity.getDoctorId());
    }
}
