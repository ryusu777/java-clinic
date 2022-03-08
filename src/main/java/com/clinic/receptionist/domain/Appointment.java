package com.clinic.receptionist.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;
public class Appointment extends AbstractEntity{
    private Integer doctorId, patientId;
    private Time appointmentTime;
    private Date appointmentDate;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "doctor_id",
                "patient_id",
                "appointment_time",
                "appointment_date");
    }

    public Appointment(Integer id) {
        super(id);
    }

    public Appointment(){
        super(null);
    }

    public Integer getDoctorId(){
        return doctorId;
    }

    public void setDoctorId(Integer doctorId){
        this.doctorId = doctorId;
    }

    public Integer getPatientId(){
        return patientId;
    }

    public void setPatientId(Integer patientId){
        this.patientId = patientId;
    }

    public Time getAppointmentTime(){
        return appointmentTime;
    }

    public void setAppointmentTime(Time appointmentTime){
        this.appointmentTime = appointmentTime;
    }

    public Date getAppointmentDate(){
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate){
        this.appointmentDate = appointmentDate;
    }
}
