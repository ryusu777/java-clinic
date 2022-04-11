// package com.clinic.receptionist.domain;

// import com.clinic.interfaces.Copyable;

// import java.sql.Date;

// import javafx.beans.property.SimpleStringProperty;
// import javafx.beans.property.StringProperty;
// import javafx.beans.property.ObjectProperty;
// import javafx.beans.property.SimpleObjectProperty;

// public class Patient extends Person implements Copyable<Patient>{
//     public Patient(Integer id){
//         super(id);
//         name = new SimpleStringProperty();
//         noKtp = new SimpleStringProperty();
//         dob = new SimpleObjectProperty<>();
//         gender = new SimpleStringProperty();
//         address = new SimpleStringProperty();
//         telp = new SimpleStringProperty();
//         guardianName = new SimpleStringProperty();
//         guardianTelp = new SimpleStringProperty();

//     }

//     public Patient(){
//         super(null);
//     }

//     private ObjectProperty<Date> dob;
//     private StringProperty name, noKtp, gender, address, telp, guardianName, guardianTelp;

//     public StringProperty nameProperty(){
//         return name;
//     }

//     public StringProperty noKtpProperty(){
//         return noKtp;
//     }

//     public ObjectProperty<Date> dobProperty(){
//         return dob;
//     }

//     public StringProperty genderProperty(){
//         return gender;
//     }

//     public StringProperty addressProperty(){
//         return address;
//     }

//     public StringProperty telpProperty(){
//         return telp;
//     }

//     public StringProperty guardianNameProperty(){
//         return guardianName;
//     }

//     public StringProperty guardianTelpProperty(){
//         return guardianTelp;
//     }


//     public String getName(){
//         return name.get();
//     }

//     public Patient setName(String name){
//         this.name.setValue(name);
//         return this;
//     }

//     public String getNoKtp(){
//         return noKtp.get();
//     }

//     public Patient setNoKtp(String noKtp){
//         this.noKtp.setValue(noKtp);
//         return this;
//     }

//     public Date getDob(){
//         return dob.get();
//     }    

//     public Patient setDob(Date dob) {
//         this.dob.setValue(dob);
//         return this;
//     }

//     public String getGender(){
//         return gender.get();
//     }

//     public Patient setGender(String gender){
//         this.gender.setValue(gender);
//         return this;
//     }

//     public String getAddress(){
//         return address.get();
//     }

//     public Patient setAddress(String address){
//         this.address.setValue(address);
//         return this;
//     }

//     public String getTelp(){
//         return telp.get();
//     }

//     public Patient setTelp(String telp){
//         this.telp.setValue(telp);
//         return this;
//     }

//     public String getGuardianName(){
//         return guardianName.get();
//     }

//     public Patient setGuardianName(String guardianName){
//         this.guardianName.setValue(guardianName);
//         return this;
//     }

//     public String getGuardianTelp(){
//         return guardianTelp.get();
//     }

//     public Patient setGuardianTelp(String guardianTelp){
//         this.guardianTelp.setValue(guardianTelp);
//         return this;
//     }

//     @Override
//     public Patient copy(Patient entity) {
//         return this
//         .setName(entity.getName())
//         .setNoKtp(entity.getNoKtp())
//         .setDob(entity.getDob())
//         .setGender(entity.getGender())
//         .setAddress(entity.getAddress())
//         .setTelp(entity.getTelp())
//         .setGuardianName(entity.getGuardianName())
//         .setGuardianTelp(entity.getGuardianTelp());
//     }
// }

package com.clinic.receptionist.domain;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.Copyable;

import java.time.LocalDate;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public class Patient extends AbstractEntity implements Copyable<Patient>{
    public Patient(Integer id){
        super(id);
        name = new SimpleStringProperty();
        noKtp = new SimpleStringProperty();
        dob = new SimpleObjectProperty<>();
        gender = new SimpleStringProperty();
        address = new SimpleStringProperty();
        telp = new SimpleStringProperty();
        guardianName = new SimpleStringProperty();
        guardianTelp = new SimpleStringProperty();
    }

    public Patient(){
        super(null);
    }

    private ObjectProperty<LocalDate> dob;
    private StringProperty name, noKtp, gender, address, telp, guardianName, guardianTelp;

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

    public StringProperty guardianNameProperty(){
        return guardianName;
    }

    public StringProperty guardianTelpProperty(){
        return guardianTelp;
    }


    public String getName(){
        return name.get();
    }

    public Patient setName(String name){
        this.name.setValue(name);
        return this;
    }

    public String getNoKtp(){
        return noKtp.get();
    }

    public Patient setNoKtp(String noKtp){
        this.noKtp.setValue(noKtp);
        return this;
    }

    public LocalDate getDob(){
        return dob.get();
    }    

    public Patient setDob(LocalDate dob) {
        this.dob.setValue(dob);
        return this;
    }

    public String getGender(){
        return gender.get();
    }

    public Patient setGender(String gender){
        this.gender.setValue(gender);
        return this;
    }

    public String getAddress(){
        return address.get();
    }

    public Patient setAddress(String address){
        this.address.setValue(address);
        return this;
    }

    public String getTelp(){
        return telp.get();
    }

    public Patient setTelp(String telp){
        this.telp.setValue(telp);
        return this;
    }

    public String getGuardianName(){
        return guardianName.get();
    }

    public Patient setGuardianName(String guardianName){
        this.guardianName.setValue(guardianName);
        return this;
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
        return this
        .setName(entity.getName())
        .setNoKtp(entity.getNoKtp())
        .setDob(entity.getDob())
        .setGender(entity.getGender())
        .setAddress(entity.getAddress())
        .setTelp(entity.getTelp())
        .setGuardianName(entity.getGuardianName())
        .setGuardianTelp(entity.getGuardianTelp());
    }
}
