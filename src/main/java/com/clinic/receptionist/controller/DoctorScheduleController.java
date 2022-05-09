package com.clinic.receptionist.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.domain.DoctorSchedule;
import com.clinic.receptionist.repository.DoctorScheduleRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
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
    @Override
    protected void initTableViewSchema(MFXTableView<DoctorSchedule> entityTable) {
        addTableColumn(entityTable, "Id", DoctorSchedule::getId);
        addTableColumn(entityTable, "Doctor Id", DoctorSchedule::getDoctorId);
        addTableColumn(entityTable, "Works Start", DoctorSchedule::getWorksStart);
        addTableColumn(entityTable, "Works End", DoctorSchedule::getWorksEnd);
    }
}
