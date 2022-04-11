package com.clinic.receptionist.domain;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;

public class Doctor extends AbstractEntity{
    public Doctor(Integer id){
        super(id);
    }

    public Doctor(){
        super(null);
    }

    private Date Dob;
    private String Name, BirthPlace, Gender, Nationality, Address, EmailAddress, Telp, NoKtp, NoNPAIDI, NoSIP, Specialism, FirstDegree, LastDegree;


    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "name",
                "birth_place",
                "dob",
                "gender",
                "nationality",
                "address",
                "email_address",
                "telp",
                "no_ktp",
                "no_npa_idi",
                "no_sip",
                "specialism",
                "first_degree",
                "last_degree");
    }

    public String getName(){
        return Name;
    }

    public void setName(String name){
        this.Name = name;
    }
    public String getBirthPlace(){
        return BirthPlace;
    }

    public void setBirthPlace(String BirthPlace){
        this.BirthPlace = BirthPlace;
    }
    
    public void setGender(String Gender){
        this.Gender = Gender;
    }

    public String getGender(){
        return Gender;
    }

    public Date getDob(){
        return Dob;
    }

    public void setDob(Date Dob){
        this.Dob = Dob;
    }

    public String getNationality(){
        return Nationality;
    }

    public void setNationality(String Nationality){
        this.Nationality = Nationality;
    }
    public String getAddress(){
        return Address;
    }

    public void setAddress(String Address){
        this.Address = Address;
    }

    public String getEmailAddress(){
        return EmailAddress;
    }

    public void setEmailAddress(String EmailAddress){
        this.EmailAddress = EmailAddress;
    }
    public String getTelp(){
        return Telp;
    }

    public void setTelp(String Telp){
        this.Telp = Telp;
    }
    public String getNoKTP(){
        return NoKtp;
    }

    public void setNoKTP(String NoKtp){
        this.NoKtp = NoKtp;
    }
    public String getNoNpaIdi(){
        return NoNPAIDI;
    }

    public void setNoNpaIdi(String NoNPAIDI){
        this.NoNPAIDI = NoNPAIDI;
    }
    public String getNoSIP(){
        return NoSIP;
    }

    public void setNoSIP(String NoSIP){
        this.NoSIP = NoSIP;
    }
    public String getSpecialism(){
        return Specialism;
    }

    public void setSpecialism(String Specialism){
        this.Specialism = Specialism;
    }
    public String getFirstDegree(){
        return FirstDegree;
    }

    public void setFirstDegree(String FirstDegree){
        this.FirstDegree = FirstDegree;
    }
    public String getLastDegree(){
        return LastDegree;
    }

    public void setLastDegree(String LastDegree){
        this.LastDegree = LastDegree;
    }
}