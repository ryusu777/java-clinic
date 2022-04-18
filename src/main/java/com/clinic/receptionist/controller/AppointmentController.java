package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.domain.Appointment;
import com.clinic.receptionist.repository.AppointmentRepository;
import javafx.scene.layout.GridPane;


public class AppointmentController extends AbstractCrudController<Appointment, AppointmentRepository>{

    public AppointmentController() {
        super(Appointment.class, AppointmentRepository.class);
    }
    @Override
    protected void setFormGrid(GridPane formGrid, Appointment entity) {
        new GridFormBuilder(formGrid)
            .addPickField("Doctor", entity.doctorIdProperty(), CrudControllerFactory.getController(DoctorController.class), "getName")
            .addPickField("Patient", entity.patientIdProperty(), CrudControllerFactory.getController(PatientController.class), "getName")
            .addLocalDateTimeField("Date&Time", entity.appointmentDateTimeProperty())
            .addIntegerField("Category", entity.categoryProperty())
            .addIntegerField("Status", entity.statusProperty());
        
        formGrid.add(generateSubmitButton("Submit", entity), 0, 6);
        
    }
}
