package com.clinic.receptionist.domain;

import java.util.Date;

import com.clinic.AbstractEntity;

public class Patient extends AbstractEntity {
    private Character gender;
    private Date birthDate;
    private Integer age;
    private String patientName, noKtp, address, patientTelp, guardianName, guardianTelp;

    public Patient(Integer id){
        super(id);
    }

    public Patient(){
        super(null);
    }

    public String getPatientName(){
        return patientName;
    }

    public void setPatientName(String patientName){
        this.patientName = patientName;
    }

    public String getNoKtp(){
        return noKtp;
    }

    public void setNoKtp(String noKtp){
        this.noKtp = noKtp;
    }

    public Date getBirthDate(){
        return birthDate;
    }

    public void setBirthDate(Date birthDate){
        this.birthDate = birthDate;
    }

    public Integer getAge(){
        // TODO: logic for age
        return age;
    }

    public Character getGender(){
        return gender;
    }

    public void setGender(Character gender){
        this.gender = gender;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getPatientTelp(){
        return patientTelp;
    }

    public void setPatientTelp(String patientTelp){
        this.patientTelp = patientTelp;
    }

    public String getGuardianName(){
        return guardianName;
    }

    public void setGuardianName(String guardianName){
        this.guardianName = guardianName;
    }

    public String getGuardianTelp(){
        return guardianTelp;
    }

    public void setGuardianTelp(String guardianTelp){
        this.guardianTelp = guardianTelp;
    }
}
