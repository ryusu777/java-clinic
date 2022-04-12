package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.domain.DoctorSchedule;
import com.clinic.receptionist.repository.DoctorScheduleRepository;
import javafx.scene.layout.GridPane;

public class DoctorScheduleController extends AbstractCrudController<DoctorSchedule, DoctorScheduleRepository>{

    public DoctorScheduleController() {
        super(DoctorSchedule.class, DoctorScheduleRepository.class);
    }
    @Override
    protected void setFormGrid(GridPane formGrid, DoctorSchedule entity) {
        new GridFormBuilder(formGrid)
            .addPickField("Doctor", entity.doctorIdProperty(), CrudControllerFactory.getController(DoctorController.class), "getName")
            .addLocalDateTimeField("Works Start", entity.worksStartProperty())
            .addLocalDateTimeField("Works End", entity.worksEndProperty());
        
        formGrid.add(generateSubmitButton("Submit", entity), 0, 4);
        
    }
}
