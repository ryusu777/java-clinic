package com.clinic.receptionist.domain;


import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;



public class DoctorSchedule extends AbstractEntity implements ICopyable<DoctorSchedule>{

    public DoctorSchedule(Integer id) {
        super(id);
    }

    public DoctorSchedule(){
        this(null);
    }
    
    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "doctor_id",
            "days",
            "works_end",
            "works_start"
        );
    }

    private IntegerProperty doctorId = new SimpleIntegerProperty();

    public IntegerProperty doctorIdProperty(){
        return doctorId;
    }

    public Integer getDoctorId(){
        return doctorId.get();
    }

    public DoctorSchedule setDoctorId(Integer doctorId){
        this.doctorId.setValue(doctorId);
        return this;
    }

    public final static String MONDAY = "1", TUESDAY = "2", WEDNESDAY = "3", THURSDAY = "4", FRIDAY = "5";

    private StringProperty worksStart = new SimpleStringProperty();

    public StringProperty worksStartProperty(){
        return worksStart;
    }

    public String getWorksStart(){
        return worksStart.get();
    }

    public DoctorSchedule setWorksStart(String worksStart){
        this.worksStart.setValue(worksStart);
        return this;
    }


    private StringProperty worksEnd = new SimpleStringProperty();

    public StringProperty worksEndProperty(){
        return worksEnd;
    }

    public String getWorksEnd(){
        return worksEnd.get();
    }

    public DoctorSchedule setWorksEnd(String worksEnd){
        this.worksEnd.setValue(worksEnd);
        return this;
    }

    
    private StringProperty days = new SimpleStringProperty();

    public StringProperty daysProperty(){
        return days;
    }

    public String getDays(){
        return days.get();
    }

    public String getDayNames(){
        switch(getDays()){
            case "1" : 
                return "Monday";
            case "2" :
                return "Tuesday";
            case "3":
                return "Wednesday";
            case "4" :
                return "Thursday";
            case "5":
                return "Friday";
        }
        return null;
    }

    public DoctorSchedule setDays(String days){
        this.days.setValue(days);
        return this;
    }

    private Doctor doctor = new Doctor();

    public Doctor getDoctor() {
        return doctor;
    }

    public DoctorSchedule setDoctor(Doctor doctor) {
        this.doctor = doctor;
        return this;
    }

    @Override
    public DoctorSchedule copy(DoctorSchedule entity) {
        return this
        .setDoctorId(entity.getDoctorId())
        .setDays(entity.getDays())
        .setWorksStart(entity.getWorksStart())
        .setWorksEnd(entity.getWorksEnd());
    }
}
