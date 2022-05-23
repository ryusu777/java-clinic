package com.clinic.drug.domain;

import java.util.Arrays;
import java.util.List;

import com.clinic.abstracts.AbstractEntity;
import com.clinic.interfaces.ICopyable;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User extends AbstractEntity implements ICopyable<User> {
    public User(Integer id) {
        super(id);
    }

    public User() {
        this(null);
    }

    @Override
    public List<String> getTableFieldNames() {
        return Arrays.asList(
            "username",
            "password",
            "user_role",
            "doctor_id"
        );
    }

    public StringProperty username = new SimpleStringProperty();
    public StringProperty usernameProperty() {
        return username;
    }

    public String getUsername() {
        return username.get();
    }

    public User setUsername(String username) {
        this.username.setValue(username);
        return this;
    }

    public StringProperty password = new SimpleStringProperty();
    public StringProperty passwordProperty() {
        return password;
    }

    public String getPassword() {
        return password.get();
    }

    public User setPassword(String password) {
        this.password.setValue(password);
        return this;
    }

    public IntegerProperty userRole = new SimpleIntegerProperty(); 
    public IntegerProperty userRoleProperty() {
        return userRole;
    }

    public Integer getUserRole() {
        return userRole.get();
    }

    public User setUserRole(Integer userRole) {
        this.userRole.setValue(userRole);
        return this;
    }

    public IntegerProperty doctorId = new SimpleIntegerProperty();
    public IntegerProperty doctorIdProperty() {
        return doctorId;
    }

    public Integer getDoctorId() {
        return doctorId.get();
    }

    public User setDoctorId(Integer doctorId) {
        this.doctorId.setValue(doctorId);
        return this;
    }

    @Override
    public User copy(User entity) {
        return this
            .setUsername(entity.getUsername())
            .setUserRole(entity.getUserRole())
            .setDoctorId(entity.getDoctorId())
            .setPassword(entity.getPassword());
    }
}
