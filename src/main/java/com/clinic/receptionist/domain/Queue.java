package com.clinic.receptionist.domain;

import java.sql.Date;
import java.sql.Time;

import com.clinic.AbstractEntity;
public class Queue extends AbstractEntity{
    private Integer doctorId, patientId;
    private Time queueTime;
    private Date queueDate;

    public Queue(Integer id) {
        super(id);
    }

    public Queue(){
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

    public Time getQueueTime(){
        return queueTime;
    }

    public void setQueueTime(Time queueTime){
        this.queueTime = queueTime;
    }

    public Date getQueueDate(){
        return queueDate;
    }

    public void setQueueTime(Date queueDate){
        this.queueDate = queueDate;
    }
}
