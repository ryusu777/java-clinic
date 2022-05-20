package com.clinic.abstracts;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class AbstractPerson extends AbstractEntity{

    public AbstractPerson(Integer id) {
        super(id);
        name = new SimpleStringProperty();
        noKtp = new SimpleStringProperty();
        dob = new SimpleObjectProperty<>();
        gender = new SimpleStringProperty();
        address = new SimpleStringProperty();
        telp = new SimpleStringProperty();
    }
    
    public AbstractPerson(){
        this(null);
    }

    private ObjectProperty<LocalDate> dob;
    private StringProperty name, noKtp, gender, address, telp;

    public final static String FEMALE = "F", MALE = "M";

    public StringProperty nameProperty(){
        return name;
    }

    public StringProperty noKtpProperty(){
        return noKtp;
    }

    public ObjectProperty<LocalDate> dobProperty(){
        return dob;
    }

    public StringProperty genderProperty(){
        return gender;
    }

    public StringProperty addressProperty(){
        return address;
    }

    public StringProperty telpProperty(){
        return telp;
    }

    public String getName(){
        return name.get();
    }

    public AbstractPerson setName(String name){
        this.name.setValue(name);
        return this;
    }

    public String getNoKtp(){
        return noKtp.get();
    }

    public AbstractPerson setNoKtp(String noKtp){
        this.noKtp.setValue(noKtp);
        return this;
    }

    public LocalDate getDob(){
        return dob.get();
    }    

    public AbstractPerson setDob(LocalDate dob) {
        this.dob.setValue(dob);
        return this;
    }

    public String getGender(){
        return gender.get();
    }

    public String getGenderDetails(){
        switch(getGender()){
            case "F" : 
                return "Female";
            case "M" :
                return "Male";
        }
        return null;
    }

    public AbstractPerson setGender(String gender){
        this.gender.setValue(gender);
        return this;
    }

    public String getAddress(){
        return address.get();
    }

    public AbstractPerson setAddress(String address){
        this.address.setValue(address);
        return this;
    }

    public String getTelp(){
        return telp.get();
    }

    public AbstractPerson setTelp(String telp){
        this.telp.setValue(telp);
        return this;
    }
}
