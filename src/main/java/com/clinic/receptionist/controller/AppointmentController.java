package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.domain.Appointment;
import com.clinic.receptionist.repository.AppointmentRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
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
    @Override
    protected void initTableViewSchema(MFXTableView<Appointment> entityTable) {
        addTableColumn(entityTable, "Id", Appointment::getId);
        addTableColumn(entityTable, "Doctor Id", Appointment::getDoctorId);
        addTableColumn(entityTable, "Patient Id", Appointment::getPatientId);
        addTableColumn(entityTable, "Date & Time", Appointment::getAppointmentDateTime);
        addTableColumn(entityTable, "Category", Appointment::getCategory);
        addTableColumn(entityTable, "Status", Appointment::getStatus);
    }
}
