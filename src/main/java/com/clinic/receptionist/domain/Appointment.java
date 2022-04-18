package com.clinic.receptionist.domain;

import java.time.LocalDateTime;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Appointment extends AbstractEntity implements Copyable<Appointment>{

    public Appointment(Integer id) {
        super(id);
        doctorId = new SimpleIntegerProperty();
        patientId =new  SimpleIntegerProperty();
        appointmentDateTime = new SimpleObjectProperty<>();
        category = new SimpleIntegerProperty();
        status = new SimpleIntegerProperty();
    }

    public Appointment(){
        super(null);
    }
    
    private IntegerProperty doctorId, patientId, category, status;
    private ObjectProperty<LocalDateTime>appointmentDateTime;

    
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

    public Integer getpatientId(){
        return patientId.get();
    }

    public Appointment setPatientId(Integer patientId){
        this.patientId.setValue(patientId);
        return this;
    }

    public LocalDateTime getappointmentDateTime(){
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

    @Override
    public Appointment copy(Appointment entity) {
        return this
        .setDoctorId(entity.getDoctorId())
        .setPatientId(entity.getpatientId())
        .setAppointmentDateTime(entity.getappointmentDateTime())
        .setCategory(entity.getCategory())
        .setStatus(entity.getStatus());
    }

}
