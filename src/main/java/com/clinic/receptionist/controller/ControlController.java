package com.clinic.receptionist.controller;

import java.sql.SQLException;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;
import com.clinic.receptionist.domain.Appointment;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.domain.Patient;
import com.clinic.receptionist.repository.AppointmentRepository;
import com.clinic.receptionist.repository.DoctorRepository;
import com.clinic.receptionist.repository.PatientRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class ControlController extends AbstractCrudController<Appointment, AppointmentRepository>{

    public ControlController() {
        super(Appointment.class, AppointmentRepository.class);
    }
    @Override
    protected void setFormGrid(GridPane formGrid, Appointment entity) {
        entity.setCategory(3);
        new GridFormBuilder(formGrid)
            .addPickField("Doctor", entity.doctorIdProperty(), CrudControllerFactory.getController(DoctorController.class), "getName")
            .addPickField("Patient", entity.patientIdProperty(), CrudControllerFactory.getController(PatientController.class), "getName")
            .addLocalDateTimeField("Date&Time", entity.appointmentDateTimeProperty())
            .addIntegerField("Status", entity.statusProperty());
        formGrid.add(generateSubmitButton("Submit", entity), 0, 6);
    }
    
    @Override
    public void fetchEntitiesToTable(MFXTableView<Appointment> entityTable, String whereClause){
        try{
            ObservableList<Appointment> entities;
            entities = FXCollections.observableArrayList(repo.join(EntityRepositoryFactory.getRepository(DoctorRepository.class), 
            EntityRepositoryFactory.getRepository(PatientRepository.class),"doctor_id", "patient_id", " WHERE category = " + 3));
            entityTable.setItems(entities);
        } catch (SQLException e){
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }
    
    @Override
    protected void initTableViewSchema(MFXTableView<Appointment> entityTable) {
        addTableColumn(entityTable, "Id", Appointment::getId);
        addTableColumn(entityTable, "Doctor Id", Appointment::getDoctor, Doctor::getName);
        addTableColumn(entityTable, "Patient Id", Appointment::getPatient, Patient::getName);
        addTableColumn(entityTable, "Date & Time", Appointment::getAppointmentDateTime);
        addTableColumn(entityTable, "Status", Appointment::getStatus);
    }
}