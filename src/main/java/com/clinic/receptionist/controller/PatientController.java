package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.receptionist.domain.Patient;
import com.clinic.receptionist.repository.PatientRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

public class PatientController extends AbstractCrudController<Patient, PatientRepository>{

    public PatientController() {
        super(Patient.class, PatientRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, Patient entity) {
        TextField nameField = new TextField();
        formGrid.addRow(1, new Label("Patient Name"), nameField);
        nameField.textProperty().bindBidirectional(entity.nameProperty());
        
        TextField noKtpField = new TextField();
        formGrid.addRow(2, new Label("No KTP"), noKtpField);
        noKtpField.textProperty().bindBidirectional(entity.noKtpProperty());
        
        DatePicker dobField = new DatePicker();
        formGrid.addRow(3, new Label("Date of Birth"), dobField);
        dobField.valueProperty().bindBidirectional(entity.dobProperty());

        TextField genderField = new TextField();
        formGrid.addRow(4, new Label("Gender"), genderField);
        genderField.textProperty().bindBidirectional(entity.genderProperty());
        
        TextField addressField = new TextField();
        formGrid.addRow(5, new Label("Address"), addressField);
        addressField.textProperty().bindBidirectional(entity.addressProperty());
        
        TextField telpField = new TextField();
        formGrid.addRow(6, new Label("Telepon"), telpField);
        telpField.textProperty().bindBidirectional(entity.telpProperty());

        TextField guardianNameField = new TextField();
        formGrid.addRow(7, new Label("Guardian Name"), guardianNameField);
        guardianNameField.textProperty().bindBidirectional(entity.guardianNameProperty());
        
        TextField guardianTelpField = new TextField();
        formGrid.addRow(8, new Label("Guardian Telp"), guardianTelpField);
        guardianTelpField.textProperty().bindBidirectional(entity.guardianTelpProperty());
        
        formGrid.add(generateSubmitButton("Submit", entity), 0, 9);
    }

    @Override
    protected void initTableViewSchema(MFXTableView<Patient> entityTable) {
        addTableColumn(entityTable, "Id", Patient::getId);
        addTableColumn(entityTable, "Name", Patient::getName);
        addTableColumn(entityTable, "No KTP", Patient::getNoKtp);
        addTableColumn(entityTable, "DoB", Patient::getDob);
        addTableColumn(entityTable, "Gender", Patient::getGender);
        addTableColumn(entityTable, "Address", Patient::getAddress);
        addTableColumn(entityTable, "Telp", Patient::getTelp);
        addTableColumn(entityTable, "Guardian Name", Patient::getGuardianName);
        addTableColumn(entityTable, "Guardian Telp", Patient::getGuardianTelp);
    }
    
}
