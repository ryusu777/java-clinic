package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.domain.Appointment;
import com.clinic.receptionist.repository.AppointmentRepository;
import javafx.scene.layout.GridPane;


public class Appointment extends AbstractCrudController<Appointment, AppointmentRepository>{

    public Appointment() {
        super(Appointment.class, AppointmentRepository.class);
    }
    @Override
    protected void setFormGrid(GridPane formGrid, Appointment entity) {
        new GridFormBuilder(formGrid)
            .addPickField("Doctor", entity.doctorIdProperty(), CrudControllerFactory.getController(DoctorController.class), "getName")
            .addLocalDateTimeField("Patient", entity.patientIdProperty())
            .addLocalDateTimeField("Date&Time", entity.appointmentDateTimeProperty());
        
        formGrid.add(generateSubmitButton("Submit", entity), 0, 4);
        
    }
}
