package com.clinic.receptionist.domain;

import java.time.LocalDateTime;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class DoctorSchedule extends AbstractEntity implements Copyable<DoctorSchedule>{

    public DoctorSchedule(Integer id) {
        super(id);
        doctorId = new SimpleIntegerProperty();
        worksStart = new SimpleObjectProperty<>();
        worksEnd = new SimpleObjectProperty<>();
    }

    public DoctorSchedule(){
        super(null);
    }
    
    private IntegerProperty doctorId;
    private ObjectProperty<LocalDateTime> worksStart, worksEnd;

    
    public IntegerProperty doctorIdProperty(){
        return doctorId;
    }

    public ObjectProperty<LocalDateTime> worksStartProperty(){
        return worksStart;
    }

    public ObjectProperty<LocalDateTime> worksEndProperty(){
        return worksEnd;
    }

    public Integer getDoctorId(){
        return doctorId.get();
    }

    public DoctorSchedule setDoctorId(Integer doctorId){
        this.doctorId.setValue(doctorId);
        return this;
    }

    public LocalDateTime getWorksStart(){
        return worksStart.get();
    }

    public DoctorSchedule setWorksStart(LocalDateTime worksStart){
        this.worksStart.setValue(worksStart);
        return this;
    }

    public LocalDateTime getWorksEnd(){
        return worksEnd.get();
    }

    public DoctorSchedule setWorksEnd(LocalDateTime worksEnd){
        this.worksEnd.setValue(worksEnd);
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
