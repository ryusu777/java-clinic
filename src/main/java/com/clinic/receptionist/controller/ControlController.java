package com.clinic.receptionist.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

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
        Map<String, Integer> items=new LinkedHashMap<>();
        items.put("Not Present", Appointment.NOT_PRESENT);
        items.put("Waiting", Appointment.WAITING);
        items.put("Consulting", Appointment.CONSULTING);
        items.put("Done", Appointment.DONE);

        entity.setCategory(3);
        new GridFormBuilder(formGrid)
            .addPickField("Doctor", entity.doctorIdProperty(), CrudControllerFactory.getController(DoctorController.class), "getName")
            .addPickField("Patient", entity.patientIdProperty(), CrudControllerFactory.getController(PatientController.class), "getName")
            .addLocalDateTimeField("Date&Time", entity.appointmentDateTimeProperty())
            .addIntegerField("Status", entity.statusProperty())
            .addComboBox("Status", entity.statusProperty().asObject(),items);

    }
    
    @Override
    public void fetchEntitiesToTable(MFXTableView<Appointment> entityTable, String whereClause){
        try{
            ObservableList<Appointment> entities;
            entities = FXCollections.observableArrayList(repo.join(EntityRepositoryFactory.getRepository(DoctorRepository.class), 
            EntityRepositoryFactory.getRepository(PatientRepository.class),"doctor_id", "patient_id", " WHERE category = " + 3 + " ORDER BY appointment_date_time "));
            entityTable.setItems(entities);
        } catch (SQLException e){
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }
    
    @Override
    protected void initTableViewSchema(MFXTableView<Appointment> entityTable) {
        addTableColumn(entityTable, "Id", Appointment::getId);
        addTableColumn(entityTable, "Doctor", Appointment::getDoctor, Doctor::getName);
        addTableColumn(entityTable, "Patient", Appointment::getPatient, Patient::getName);
        addTableColumn(entityTable, "Date", Appointment::getAppointmentDate);
        addTableColumn(entityTable, "Time", Appointment::getAppointmentTime);
        addTableColumn(entityTable, "Status", Appointment::getStatusDetail);
    }
}