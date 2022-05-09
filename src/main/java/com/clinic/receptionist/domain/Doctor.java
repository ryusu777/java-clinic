package com.clinic.receptionist.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractPerson;
import com.clinic.interfaces.Copyable;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Doctor extends AbstractPerson implements Copyable<Doctor>{
    public Doctor(Integer id){
        super(id);
    }

    public Doctor(){
        this(null);
    }

    private StringProperty BirthPlace = new SimpleStringProperty();
    private StringProperty Nationality = new SimpleStringProperty();
    private StringProperty EmailAddress = new SimpleStringProperty();
    private StringProperty NoNPAIDI = new SimpleStringProperty();
    private StringProperty NoSIP = new SimpleStringProperty();
    private StringProperty Specialism = new SimpleStringProperty();
    private StringProperty FirstDegree = new SimpleStringProperty();
    private StringProperty LastDegree = new SimpleStringProperty();
    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "name",
            "no_ktp",
            "dob",
            "gender",
            "address",
            "telp",
            "birth_place",
            "nationality",
            "email_address",
            "no_npa_idi",
            "no_sip",
            "specialism",
            "first_degree",
            "last_degree"
        );
    }

    public StringProperty BirthPlaceProperty(){
        return BirthPlace;
    }

    public StringProperty NationalityProperty(){
        return Nationality;
    }

    public StringProperty EmailAddressProperty(){
        return EmailAddress;
    }

    public StringProperty NoNpaIdiProperty(){
        return NoNPAIDI;
    }

    public StringProperty NoSIPProperty(){
        return NoSIP;
    }

    public StringProperty SpecialismProperty(){
        return Specialism;
    }

    public StringProperty FirstDegreeProperty(){
        return FirstDegree;
    }

    public StringProperty LastDegreeProperty(){
        return LastDegree;
    }

    public String getBirthPlace(){
        return BirthPlace.get();
    }

    public Doctor setBirthPlace(String BirthPlace){
        this.BirthPlace.setValue(BirthPlace);
        return this;
    }

    public String getNationality(){
        return Nationality.get();
    }

    public Doctor setNationality(String Nationality){
        this.Nationality.setValue(Nationality);
        return this;
    }

    public String getEmailAddress(){
        return EmailAddress.get();
    }

    public Doctor setEmailAddress(String EmailAddress){
        this.EmailAddress.setValue(EmailAddress);
        return this;
    }
 
    public String getNoNpaIdi(){
        return NoNPAIDI.get();
    }

    public Doctor setNoNpaIdi(String NoNPAIDI){
        this.NoNPAIDI.setValue(NoNPAIDI);
        return this;
    }

    public String getNoSIP(){
        return NoSIP.get();
    }

    public Doctor setNoSIP(String NoSIP){
        this.NoSIP.setValue(NoSIP);
        return this;
    }

    public String getSpecialism(){
        return Specialism.get();
    }

    public Doctor setSpecialism(String Specialism){
        this.Specialism.setValue(Specialism);
        return this;
    }
 
    public String getFirstDegree(){
        return FirstDegree.get();
    }

    public Doctor setFirstDegree(String FirstDegree){
        this.FirstDegree.setValue(FirstDegree);
        return this;
    }

    public String getLastDegree(){
        return LastDegree.get();
    }

    public Doctor setLastDegree(String LastDegree){
        this.LastDegree.setValue(LastDegree);
        return this;
    }

    @Override
    public Doctor copy(Doctor entity){
        Doctor doctor = (Doctor) this
        .setName(entity.getName())
        .setGender(entity.getGender())
        .setDob(entity.getDob())
        .setAddress(entity.getAddress())
        .setTelp(entity.getTelp())
        .setNoKtp(entity.getNoKtp());

        return doctor
        .setBirthPlace(entity.getBirthPlace())
        .setNationality(entity.getNationality())
        .setEmailAddress(entity.getEmailAddress())
        .setNoNpaIdi(entity.getNoNpaIdi()) 
        .setNoSIP(entity.getNoSIP())
        .setSpecialism(entity.getSpecialism())
        .setFirstDegree(entity.getFirstDegree())
        .setLastDegree(entity.getLastDegree());
        }
    }