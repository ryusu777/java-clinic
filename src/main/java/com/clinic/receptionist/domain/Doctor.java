package com.clinic.receptionist.domain;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Doctor extends AbstractEntity implements Copyable<Doctor>{
    public Doctor(Integer id){
        super(id);
        Name = new SimpleStringProperty();
        BirthPlace = new SimpleStringProperty();
        Gender = new SimpleStringProperty();
        Dob = new SimpleObjectProperty<>();
        Nationality = new SimpleStringProperty();
        Address = new SimpleStringProperty();
        EmailAddress = new SimpleStringProperty();
        Telp = new SimpleStringProperty();
        NoKtp = new SimpleStringProperty();
        NoNPAIDI = new SimpleStringProperty();
        NoSIP = new SimpleStringProperty();
        Specialism = new SimpleStringProperty();
        FirstDegree = new SimpleStringProperty();
        LastDegree = new SimpleStringProperty();
        
    }

    public Doctor(){
        super(null);
    }

    private ObjectProperty<LocalDate> Dob;
    private StringProperty Name, BirthPlace, Gender, Nationality, Address, EmailAddress, Telp, NoKtp, NoNPAIDI, NoSIP, Specialism, FirstDegree, LastDegree;

   

    public StringProperty NameProperty(){
        return Name;
    }

    public StringProperty BirthPlaceProperty(){
        return BirthPlace;
    }

    public StringProperty GenderProperty(){
        return Gender;
    }

    public ObjectProperty<LocalDate> DobProperty(){
        return Dob;
    }

    public StringProperty NationalityProperty(){
        return Nationality;
    }

   
    public StringProperty AddressProperty(){
        return Address;
    }

    public StringProperty EmailAddressProperty(){
        return EmailAddress;
    }

    public StringProperty TelpProperty(){
        return Telp;
    }

    public StringProperty NoKTPProperty(){
        return NoKtp;
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

    public String getName(){
        return Name.get();
    }

    public Doctor setName(String name){
        this.Name.setValue(name);
        return this;
    }

    public String getBirthPlace(){
        return BirthPlace.get();
    }

    public Doctor setBirthPlace(String BirthPlace){
        this.BirthPlace.setValue(BirthPlace);
        return this;
    }

    public String getGender(){
        return Gender.get();
    }

    public Doctor setGender(String Gender){
        this.Gender.setValue(Gender);
        return this;
    }

    public LocalDate getDob(){
        return Dob.get();
    }    

    public Doctor setDob(LocalDate Dob) {
        this.Dob.setValue(Dob);
        return this;
    }

    public String getNationality(){
        return Nationality.get();
    }

    public Doctor setNationality(String Nationality){
        this.Nationality.setValue(Nationality);
        return this;
    }

    public String getAddress(){
        return Address.get();
    }

    public Doctor setAddress(String Address){
        this.Address.setValue(Address);
        return this;
    }

    public String getEmailAddress(){
        return EmailAddress.get();
    }

    public Doctor setEmailAddress(String EmailAddress){
        this.EmailAddress.setValue(EmailAddress);
        return this;
    }

    public String getTelp(){
        return Telp.get();
    }

    public Doctor setTelp(String Telp){
        this.Telp.setValue(Telp);
        return this;
    }

    public String getNoKtp(){
        return NoKtp.get();
    }

    public Doctor setNoKtp(String NoKtp){
        this.NoKtp.setValue(NoKtp);
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
        return this
        .setName(entity.getName())
        .setBirthPlace(entity.getBirthPlace())
        .setGender(entity.getGender())
        .setDob(entity.getDob())
        .setNationality(entity.getNationality())
        .setAddress(entity.getAddress())
        .setEmailAddress(entity.getEmailAddress()) 
        .setTelp(entity.getTelp())
        .setNoKtp(entity.getNoKtp())
        .setNoNpaIdi(entity.getNoNpaIdi()) 
        .setNoSIP(entity.getNoSIP())
        .setSpecialism(entity.getSpecialism())
        .setFirstDegree(entity.getFirstDegree())
        .setLastDegree(entity.getLastDegree());
        }
    }