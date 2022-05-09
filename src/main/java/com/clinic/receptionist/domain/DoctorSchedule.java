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

public class DoctorSchedule extends AbstractEntity implements Copyable<DoctorSchedule>{

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


    private ObjectProperty<LocalDateTime> worksStart = new SimpleObjectProperty<>();

    public ObjectProperty<LocalDateTime> worksStartProperty(){
        return worksStart;
    }

    public LocalDateTime getWorksStart(){
        return worksStart.get();
    }

    public DoctorSchedule setWorksStart(LocalDateTime worksStart){
        this.worksStart.setValue(worksStart);
        return this;
    }


    private ObjectProperty<LocalDateTime> worksEnd = new SimpleObjectProperty<>();

    public ObjectProperty<LocalDateTime> worksEndProperty(){
        return worksEnd;
    }

    public LocalDateTime getWorksEnd(){
        return worksEnd.get();
    }

    public DoctorSchedule setWorksEnd(LocalDateTime worksEnd){
        this.worksEnd.setValue(worksEnd);
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
        .setWorksStart(entity.getWorksStart())
        .setWorksEnd(entity.getWorksEnd());
    }
}
