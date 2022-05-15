package com.clinic.receptionist.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Appointment extends AbstractEntity implements Copyable<Appointment>{

    public Appointment(Integer id) {
        super(id);
    }

    public Appointment(){
        super(null);
    }
    
    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "doctor_id",
            "patient_id",
            "appointment_date_time",
            "category",
            "status"
        );
    }
    
    private IntegerProperty doctorId = new SimpleIntegerProperty();
    private IntegerProperty patientId = new SimpleIntegerProperty();
    private IntegerProperty category = new SimpleIntegerProperty();
    private IntegerProperty status = new SimpleIntegerProperty();
    private ObjectProperty<LocalDateTime>appointmentDateTime = new SimpleObjectProperty<>();

    public IntegerProperty doctorIdProperty(){
        return doctorId;
    }

    public IntegerProperty patientIdProperty(){
        return patientId;
    }

    public ObjectProperty<LocalDateTime> appointmentDateTimeProperty(){
        return appointmentDateTime;
    }

    public IntegerProperty categoryProperty(){
        return category;
    }

    public IntegerProperty statusProperty(){
        return status;
    }

    public Integer getDoctorId(){
        return doctorId.get();
    }

    public Appointment setDoctorId(Integer doctorId){
        this.doctorId.setValue(doctorId);
        return this;
    }

    public Integer getPatientId(){
        return patientId.get();
    }

    public Appointment setPatientId(Integer patientId){
        this.patientId.setValue(patientId);
        return this;
    }

    public LocalDateTime getAppointmentDateTime(){
        return appointmentDateTime.get();
    }

    public Appointment setAppointmentDateTime(LocalDateTime appointmentDateTime){
        this.appointmentDateTime.setValue(appointmentDateTime);
        return this;
    }

    public Integer getCategory(){
        return category.get();
    }

    public Appointment setCategory(Integer category){
        this.category.setValue(category);
        return this;
    }

    public Integer getStatus(){
        return status.get();
    }

    public Appointment setStatus(Integer status){
        this.status.setValue(status);
        return this;
    }

    private Doctor doctor = new Doctor();

    public Doctor getDoctor() {
        return doctor;
    }

    public Appointment setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    
    private Patient patient = new Patient();

    public Patient getPatient() {
        return patient;
    }

    public Appointment setPatient(Patient patient) {
        this.patient = patient;
        return this;
    }


    @Override
    public Appointment copy(Appointment entity) {
        return this
        .setDoctorId(entity.getDoctorId())
        .setPatientId(entity.getPatientId())
        .setAppointmentDateTime(entity.getAppointmentDateTime())
        .setCategory(entity.getCategory())
        .setStatus(entity.getStatus());
    }
}
