package com.clinic.receptionist.controller;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.domain.DoctorSchedule;
import com.clinic.receptionist.repository.DoctorRepository;
import com.clinic.receptionist.repository.DoctorScheduleRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.GridPane;

public class DoctorScheduleController extends AbstractCrudController<DoctorSchedule, DoctorScheduleRepository>{

    public DoctorScheduleController() {
        super(DoctorSchedule.class, DoctorScheduleRepository.class, "Doctor Schedule");
    }
    @Override
    protected void setFormGrid(GridPane formGrid, DoctorSchedule entity) {
        Map<String, String> items = new LinkedHashMap<>();
        items.put("Monday", DoctorSchedule.MONDAY);
        items.put("Tuesday", DoctorSchedule.TUESDAY);
        items.put("Wednesday", DoctorSchedule.WEDNESDAY);
        items.put("Thursday", DoctorSchedule.THURSDAY);
        items.put("Friday", DoctorSchedule.FRIDAY);
        
        new GridFormBuilder(formGrid)
            .addPickField("Doctor", entity.doctorIdProperty(), CrudControllerFactory.getController(DoctorController.class), "getName")
            .addTextField("Works Start", entity.worksStartProperty())
            .addTextField("Works End", entity.worksEndProperty())
            .addComboBox("Day", entity.daysProperty(), items)
            // .addTextField("Start", entity.startProperty())
            // .addTextField("End", entity.endProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }
    @Override
    public void fetchEntitiesToTable(MFXTableView<DoctorSchedule> entityTable, String whereClause){
        ObservableList<DoctorSchedule> entities;
        try{
            entities = FXCollections.observableArrayList(repo.join(EntityRepositoryFactory.getRepository(DoctorRepository.class), "doctor_id"));
            entityTable.setItems(entities);
        } catch (SQLException e){
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }

    @Override
    protected void initTableViewSchema(MFXTableView<DoctorSchedule> entityTable) {
        addTableColumn(entityTable, "Id", DoctorSchedule::getId);
        addTableColumn(entityTable, "Doctor Name", DoctorSchedule::getDoctor, Doctor::getName);
        addTableColumn(entityTable, "Works Days", DoctorSchedule::getDayNames);
        addTableColumn(entityTable, "Works Start", DoctorSchedule::getWorksStart);
        addTableColumn(entityTable, "Works End", DoctorSchedule::getWorksEnd);
    }
}
