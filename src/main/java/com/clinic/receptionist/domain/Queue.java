package com.clinic.receptionist.domain;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;
public class Queue extends AbstractEntity{
    private Integer doctorId, patientId;
    private Time queueTime;
    private Date queueDate;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "doctor_id",
                "patient_id",
                "queue_time",
                "queue_date");
    }

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

    public void setQueueDate(Date queueDate){
        this.queueDate = queueDate;
    }
}
