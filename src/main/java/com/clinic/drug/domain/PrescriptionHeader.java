package com.clinic.drug.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

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
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "created_date",
            "doctor_id",
            "patient_id",
            "medical_record_id"
        );
    }

    private ObjectProperty<LocalDate> createdDate = new SimpleObjectProperty<>();
    public ObjectProperty<LocalDate> createdDateProperty() {
        return this.createdDate;
    }

    public LocalDate getCreatedDate() {
        return createdDate.get();
    }

    public PrescriptionHeader setCreatedDate(LocalDate createdDate) {
        this.createdDate.setValue(createdDate);
        return this;
    }

    private IntegerProperty doctorId = new SimpleIntegerProperty();
    public IntegerProperty doctorIdProperty() {
        return this.doctorId;
    }

    public Integer getDoctorId() {
        return doctorId.get();
    }

    public PrescriptionHeader setDoctorId(Integer doctorId) {
        this.doctorId.setValue(doctorId);
        return this;
    }

    private IntegerProperty patientId = new SimpleIntegerProperty();
    public IntegerProperty patientIdProperty() {
        return this.patientId;
    }

    public Integer getPatientId() {
        return patientId.get();
    }

    public PrescriptionHeader setPatientId(Integer patientId) {
        this.patientId.setValue(patientId);
        return this;
    }

    private IntegerProperty medicalRecordId = new SimpleIntegerProperty();
    public IntegerProperty medicalRecordIdProperty() {
        return this.medicalRecordId;
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
