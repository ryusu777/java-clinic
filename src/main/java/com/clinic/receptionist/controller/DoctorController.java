package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.repository.DoctorRepository;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

public class DoctorController extends AbstractCrudController<Doctor, DoctorRepository>{

    public DoctorController() {
        super(Doctor.class, DoctorRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, Doctor entity) {
        TextField NameField = new TextField();
        formGrid.addRow(1, new Label("Name"), NameField);
        NameField.textProperty().bindBidirectional(entity.NameProperty());
        
        TextField BirthPlaceField = new TextField();
        formGrid.addRow(2, new Label("Birth Place"), BirthPlaceField);
        BirthPlaceField.textProperty().bindBidirectional(entity.BirthPlaceProperty());
        
        TextField GenderField = new TextField();
        formGrid.addRow(3, new Label("Gender"), GenderField);
        GenderField.textProperty().bindBidirectional(entity.GenderProperty());

        DatePicker DobField = new DatePicker();
        formGrid.addRow(4, new Label("Date of Birth"), DobField);
        DobField.valueProperty().bindBidirectional(entity.DobProperty());

        TextField NationalityField = new TextField();
        formGrid.addRow(5, new Label("Nationality"), NationalityField);
        NationalityField.textProperty().bindBidirectional(entity.NationalityProperty());
        
        TextField AddressField = new TextField();
        formGrid.addRow(6, new Label("Address"), AddressField);
        AddressField.textProperty().bindBidirectional(entity.AddressProperty());
        
        TextField EmailAddressField = new TextField();
        formGrid.addRow(7, new Label("EmailAddress"), EmailAddressField);
        EmailAddressField.textProperty().bindBidirectional(entity.EmailAddressProperty());

        TextField TelpField = new TextField();
        formGrid.addRow(8, new Label("Telp"), TelpField);
        TelpField.textProperty().bindBidirectional(entity.TelpProperty());
        
        TextField NoKtpField = new TextField();
        formGrid.addRow(9, new Label("No Ktp"), NoKtpField);
        NoKtpField.textProperty().bindBidirectional(entity.NoKTPProperty());
        
        TextField NoNPAIDIField = new TextField();
        formGrid.addRow(10, new Label("No NPA IDI"), NoNPAIDIField);
        NoNPAIDIField.textProperty().bindBidirectional(entity.NoNpaIdiProperty());

        TextField NoSIPField = new TextField();
        formGrid.addRow(11, new Label("No SIP"), NoSIPField);
        NoSIPField.textProperty().bindBidirectional(entity.NoSIPProperty());

        TextField SpecialismField = new TextField();
        formGrid.addRow(12, new Label("Specialism"), SpecialismField);
        SpecialismField.textProperty().bindBidirectional(entity.SpecialismProperty());

        TextField FirstDegreeField = new TextField();
        formGrid.addRow(13, new Label("First Degree"), FirstDegreeField);
        FirstDegreeField.textProperty().bindBidirectional(entity.FirstDegreeProperty());

        TextField LastDegreeField = new TextField();
        formGrid.addRow(14, new Label("Last egree"), LastDegreeField);
        LastDegreeField.textProperty().bindBidirectional(entity.LastDegreeProperty());

        formGrid.add(generateSubmitButton("Submit", entity), 0, 15);
    }
    
}
