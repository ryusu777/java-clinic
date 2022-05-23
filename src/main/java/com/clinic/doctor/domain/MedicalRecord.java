package com.clinic.doctor.domain;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.domain.Patient;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
public class MedicalRecord extends AbstractEntity implements ICopyable <MedicalRecord> {
    public MedicalRecord() {
        this(null);
    }

    public MedicalRecord(Integer id) {
        super(id);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "patient_id",
            "doctor_id",
            "prescription_header_id",
            "symptom",
            "treatment",
            "check_up_date"
        );
    }

    private IntegerProperty patientId = new SimpleIntegerProperty();
    private IntegerProperty doctorId = new SimpleIntegerProperty();
    private IntegerProperty prescriptionHeaderId = new SimpleIntegerProperty();
    private StringProperty symptom = new SimpleStringProperty();
    private StringProperty treatment = new SimpleStringProperty();
    private ObjectProperty<LocalDate> checkUpDate = new SimpleObjectProperty<>();

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

    private Doctor doctor = new Doctor();

    public Doctor getDoctor() {
        return doctor;
    }

    public MedicalRecord setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    private Patient patient = new Patient();

    public Patient getPatient() {
        return patient;
    }

    public MedicalRecord setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }

    // private PrescriptionHeader prescriptionHeader= new PrescriptionHeader();

    // public PrescriptionHeader getPrescriptionHeader() {
    //     return prescriptionHeader;
    // }

    // public MedicalRecord setPrescriptionHeader(PrescriptionHeader prescriptionHeader) {
    //     this.prescriptionHeader = prescriptionHeader;
    //     return this;
    // }

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
