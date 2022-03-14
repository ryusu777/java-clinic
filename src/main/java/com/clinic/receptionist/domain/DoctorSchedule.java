package com.clinic.receptionist.domain;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;
public class DoctorSchedule extends AbstractEntity{
    private Integer doctorId;
    private Timestamp worksStart, worksEnd;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "doctor_id",
                "works_start",
                "works_end");
    }

    public DoctorSchedule(Integer id) {
        super(id);
    }

    public DoctorSchedule(){
        super(null);
    }

    public Integer getDoctorId(){
        return doctorId;
    }

    public void setDoctorId(Integer doctorId){
        this.doctorId = doctorId;
    }

    public Timestamp getWorksStart(){
        return worksStart;
    }

    public void setWorksStart(Timestamp worksStart){
        this.worksStart = worksStart;
    }

    public Timestamp getWorksEnd(){
        return worksEnd;
    }

    public void setWorksEnd(Timestamp worksEnd){
        this.worksEnd = worksEnd;
    }
}
