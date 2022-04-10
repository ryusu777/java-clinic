package com.clinic.drug.domain;

import java.time.LocalDate;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

public class PrescriptionHeader extends AbstractEntity implements Copyable<PrescriptionHeader> {
    public PrescriptionHeader() {
        this(null);
    }

    public PrescriptionHeader(Integer id) {
        super(id);
        createdDate = new SimpleObjectProperty<>();
        doctorId = new SimpleIntegerProperty();
        patientId = new SimpleIntegerProperty();
        medicalRecordId = new SimpleIntegerProperty();
    }
    
    private ObjectProperty<LocalDate> createdDate;
    private IntegerProperty doctorId, patientId, medicalRecordId;

    public ObjectProperty<LocalDate> createdDateProperty() {
        return this.createdDate;
    }

    public IntegerProperty doctorIdProperty() {
        return this.doctorId;
    }

    public IntegerProperty patientIdProperty() {
        return this.patientId;
    }

    public IntegerProperty medicalRecordIdProperty() {
        return this.medicalRecordId;
    }

    public LocalDate getCreatedDate() {
        return createdDate.get();
    }

    public PrescriptionHeader setCreatedDate(LocalDate createdDate) {
        this.createdDate.setValue(createdDate);
        return this;
    }

    public Integer getDoctorId() {
        return doctorId.get();
    }

    public PrescriptionHeader setDoctorId(Integer doctorId) {
        this.doctorId.setValue(doctorId);
        return this;
    }

    public Integer getPatientId() {
        return patientId.get();
    }

    public PrescriptionHeader setPatientId(Integer patientId) {
        this.patientId.setValue(patientId);
        return this;
    }

    public Integer getMedicalRecordId() {
        return medicalRecordId.get();
    }

    public PrescriptionHeader setMedicalRecordId(Integer medicalRecordId) {
        this.medicalRecordId.setValue(medicalRecordId);
        return this;
    }

    @Override
    public PrescriptionHeader copy(PrescriptionHeader entity) {
        return this
            .setCreatedDate(entity.getCreatedDate())
            .setDoctorId(entity.getDoctorId())
            .setMedicalRecordId(entity.getMedicalRecordId())
            .setPatientId(entity.getPatientId());
    }
}
