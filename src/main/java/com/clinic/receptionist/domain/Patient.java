package com.clinic.receptionist.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractPerson;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Patient extends AbstractPerson implements ICopyable<Patient>{
    public Patient(Integer id){
        super(id);
    }

    public Patient(){
        this(null);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "name",
            "no_ktp",
            "dob",
            "gender",
            "address",
            "telp",
            "guardian_name",
            "guardian_telp"
        );
    }

    private StringProperty guardianName = new SimpleStringProperty();

    public StringProperty guardianNameProperty(){
        return guardianName;
    }

    public String getGuardianName(){
        return guardianName.get();
    }

    public Patient setGuardianName(String guardianName){
        this.guardianName.setValue(guardianName);
        return this;
    }
    
    private StringProperty guardianTelp = new SimpleStringProperty();

    public StringProperty guardianTelpProperty(){
        return guardianTelp;
    }

    public String getGuardianTelp(){
        return guardianTelp.get();
    }

    public Patient setGuardianTelp(String guardianTelp){
        this.guardianTelp.setValue(guardianTelp);
        return this;
    }

    @Override
    public Patient copy(Patient entity) {
        Patient patient = (Patient) this
        .setName(entity.getName())
        .setNoKtp(entity.getNoKtp())
        .setDob(entity.getDob())
        .setGender(entity.getGender())
        .setAddress(entity.getAddress())
        .setTelp(entity.getTelp());
        
        return patient
        .setGuardianName(entity.getGuardianName())
        .setGuardianTelp(entity.getGuardianTelp());
    }
}
