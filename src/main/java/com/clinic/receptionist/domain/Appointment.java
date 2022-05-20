package com.clinic.receptionist.domain;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Appointment extends AbstractEntity implements ICopyable<Appointment>{

    public Appointment(Integer id) {
        super(id);
    }

    public Appointment(){
        super(null);
    }

    public final static int NOT_PRESENT = 1, WAITING = 2, CONSULTING = 3, DONE = 4,
    APPOINTMENT = 1, QUEUE = 2, CONTROL = 3;
    
    
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

    public String getCategoryDetail(){
        switch(getCategory()){
            case 1 : 
                return "Appointment";
            case 2 :
                return "Queue";
            case 3:
                return "Control";
        }
        return null;
    }

    public Appointment setCategory(Integer category){
        this.category.setValue(category);
        return this;
    }

    public Integer getStatus(){
        return status.get();
    }

    public String getStatusDetail(){
        switch(getStatus()){
            case 1 : 
                return "Not Present";
            case 2 :
                return "Waiting";
            case 3:
                return "Consulting";
            case 4 :
                return "Done";
        }
        return null;
    }

    public String getAppointmentDate(){
        return getAppointmentDateTime().getDayOfMonth() + "-" + getAppointmentDateTime().getMonth().toString() + "-" + 
                getAppointmentDateTime().getYear();
    }

    public String getAppointmentTime(){
        return getAppointmentDateTime().getHour() + ":" + getAppointmentDateTime().getMinute();
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
