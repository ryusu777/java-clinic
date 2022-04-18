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
    }

    public Appointment(){
        super(null);
    }
    
    private IntegerProperty doctorId, patientId;
    private ObjectProperty<LocalDateTime>appointmentDateTime;

    
    public IntegerProperty doctorIdProperty(){
        return doctorId;
    }

    public IntegerProperty patientIdIdProperty(){
        return patientId;
    }

    public ObjectProperty<LocalDateTime> worksEndProperty(){
        return appointmentDateTime;
    }

    public Integer getDoctorId(){
        return doctorId.get();
    }

    public Appointment setDoctorId(Integer doctorId){
        this.doctorId.setValue(doctorId);
        return this;
    }

    public LocalDateTime getpatientId(){
        return patientId.get();
    }

    public Appointment setPatientId(LocalDateTime patientId){
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

    @Override
    public Appointment copy(Appointment entity) {
        return this
        .setDoctorId(entity.getDoctorId())
        .setPatientId(entity.getpatientId())
        .setAppointmentDateTime(entity.getappointmentDateTime());
    }

}
