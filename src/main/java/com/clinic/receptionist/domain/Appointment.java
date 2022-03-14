package com.clinic.receptionist.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;
public class Appointment extends AbstractEntity{
    private Integer doctorId, patientId, category, status;
    private Timestamp appointmentTimeDate;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "doctor_id",
                "patient_id",
                "category",
                "status",
                "appointment_date_time");
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

    public Timestamp getAppointmentTime_Date(){
        return appointmentTimeDate;
    }

    public void setAppointmentTime(Timestamp appointmentTimeDate){
        this.appointmentTimeDate = appointmentTimeDate;
    }

    public Integer getCategory(){
        return category;
    }

    public void setCategory(Integer category){
        this.doctorId = doctorId;
    }

    public Integer getStatus(){
        return status;
    }

    public void setStatus(Integer status){
        this.status = status;
    }
}
