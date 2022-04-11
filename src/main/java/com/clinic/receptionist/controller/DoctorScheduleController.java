package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.receptionist.domain.DoctorSchedule;
import com.clinic.receptionist.domain.Patient;
import com.clinic.receptionist.repository.DoctorScheduleRepository;
import com.clinic.receptionist.repository.PatientRepository;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;

public class DoctorScheduleController extends AbstractCrudController<DoctorSchedule, DoctorScheduleRepository>{

    public DoctorScheduleController() {
        super(DoctorSchedule.class, DoctorScheduleRepository.class);
    }
    @Override
    protected void setFormGrid(GridPane formGrid, DoctorSchedule entity) {
        // TextField doctorIdField = new TextField();
        // formGrid.addRow(1, new Label("Id Doctor"), doctorIdField);
        // doctorIdField.textProperty().bindBidirectional(entity.doctorIdProperty());

        // TextField worksStartField = new TextField();
        // formGrid.addRow(2, new Label("Works Start"), worksStartField);
        // worksStartField.textProperty().bindBidirectional(entity.worksStartProperty());
        
        // TextField worksEndField = new TextField();
        // formGrid.addRow(3, new Label("Works End"), worksStartField);
        // worksEndField.textProperty().bindBidirectional(entity.worksEndProperty());

        // GridFormBuilder.addIntegerField("Id Doctor", entity.doctorIdProperty());

        GridFormBuilder doctorIdField = new GridFormBuilder(formGrid);
        doctorIdField.addIntegerField("Id Doctor", entity.doctorIdProperty());

        // GridFormBuilder.addLocalDateTimeField("Works Start", entity.worksStartProperty());

        GridFormBuilder worksStartField = new GridFormBuilder(formGrid);
        worksStartField.addLocalDateTimeField("Works Start", entity.worksStartProperty());

        // GridFormBuilder.addLocalDateTimeField("Works End", entity.worksEndProperty());

        GridFormBuilder worksEndField = new GridFormBuilder(formGrid);
        worksEndField.addLocalDateTimeField("Works End", entity.worksEndProperty());
        
        
        formGrid.add(generateSubmitButton("Submit", entity), 0, 4);
        
    }
    
}
