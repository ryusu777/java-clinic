package com.clinic.receptionist.domain;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.clinic.AbstractEntity;

public class Patient extends AbstractEntity {
    public Patient(Integer id){
        super(id);
    }

    public Patient(){
        super(null);
    }

    private Date dob;
    private String gender;
    private String patientName, noKtp, address, patientTelp, guardianName, guardianTelp;

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
                "patient_name",
                "no_ktp",
                "dob",
                "gender",
                "address",
                "patient_telp",
                "guardian_name",
                "guardian_telp");
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

    public Date getDob(){
        return dob;
    }    

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
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
