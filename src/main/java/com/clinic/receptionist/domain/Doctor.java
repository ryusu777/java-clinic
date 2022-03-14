package com.clinic.receptionist.domain;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;
public class Doctor extends AbstractEntity{
    public Doctor(Integer id){
        super(id);
    }

    public Doctor(){
        super(null);
    }

    private String DoctorName, BirthPlace, Nationality, Address, EmailAddress, DoctorTelp, NoKTP, NoNPAIDI, NoSIP, Specialism, FirstDegree, LastDegree;
    private Date BirthDate;


    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "doctor_name",
                "birth_place",
                "birth_date",
                "nationality",
                "address",
                "email_address",
                "doctor_telp",
                "no_ktp",
                "no_npa_idi",
                "no_sip",
                "specialism",
                "first_degree",
                "last_degree");
    }

    public String getDoctorName(){
        return DoctorName;
    }

    public void setDoctorName(String DoctorName){
        this.DoctorName = DoctorName;
    }
    public String getBirthPlace(){
        return BirthPlace;
    }

    public void setBirthPlace(String BirthPlace){
        this.BirthPlace = BirthPlace;
    }

    public Date getBirthDate(){
        return BirthDate;
    }

    public void setBirthDate(Date BirthDate){
        this.BirthDate = BirthDate;
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
    public String getDoctorTelp(){
        return DoctorTelp;
    }

    public void setDoctorTelp(String DoctorTelp){
        this.DoctorTelp = DoctorTelp;
    }
    public String getNoKTP(){
        return NoKTP;
    }

    public void setNoKTP(String NoKTP){
        this.NoKTP = NoKTP;
    }
    public String getNoNPAIDI(){
        return NoNPAIDI;
    }

    public void setNoNPAIDI(String NoNPAIDI){
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