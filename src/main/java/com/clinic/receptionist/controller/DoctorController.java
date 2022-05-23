package com.clinic.receptionist.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.domain.Doctor;
import com.clinic.receptionist.repository.DoctorRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class DoctorController extends AbstractCrudController<Doctor, DoctorRepository>{

    public DoctorController() {
        super(Doctor.class, DoctorRepository.class);
        childControllers.add(CrudControllerFactory.getController(DoctorScheduleController.class));
    }

    @Override
    protected void setFormGrid(GridPane formGrid, Doctor entity) {
        Map<String, String> items = new LinkedHashMap<>();
        items.put("Female", Doctor.FEMALE);
        items.put("Male",Doctor.MALE);

        new GridFormBuilder(formGrid)
            .addTextField("Name", entity.nameProperty())
            .addTextField("No KTP", entity.noKtpProperty())
            .addTextField("Birth Place", entity.BirthPlaceProperty())
            .addLocalDateField("Date of Birth", entity.dobProperty())
            .addComboBox("Gender", entity.genderProperty(), items)
            .addTextField("Nationality", entity.NationalityProperty())
            .addTextField("Address", entity.addressProperty())
            .addTextField("Email Address", entity.EmailAddressProperty())
            .addTextField("Phone Number", entity.telpProperty())
            .addTextField("NPA IDI Number", entity.NoNpaIdiProperty())
            .addTextField("SIP Number", entity.NoSIPProperty())
            .addTextField("Specialism", entity.SpecialismProperty())
            .addTextField("First Degree", entity.FirstDegreeProperty())
            .addTextField("Last Degree", entity.LastDegreeProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<Doctor> entityTable) {
        addTableColumn(entityTable, "Id", Doctor::getId);
        addTableColumn(entityTable, "Name", Doctor::getName);
        addTableColumn(entityTable, "Gender", Doctor::getGenderDetails);
        addTableColumn(entityTable, "Birth Place", Doctor::getBirthPlace);
        addTableColumn(entityTable, "DoB", Doctor::getDob);
        addTableColumn(entityTable, "Nationality", Doctor::getNationality);
        addTableColumn(entityTable, "No KTP", Doctor::getNoKtp);
        addTableColumn(entityTable, "Address", Doctor::getAddress);
        addTableColumn(entityTable, "Telp", Doctor::getTelp);
        addTableColumn(entityTable, "Email Address", Doctor::getEmailAddress);
        addTableColumn(entityTable, "No NPA IDI", Doctor::getNoNpaIdi);
        addTableColumn(entityTable, "No SIP", Doctor::getNoSIP);
        addTableColumn(entityTable, "Specialism", Doctor::getSpecialism);
        addTableColumn(entityTable, "First Degree", Doctor::getFirstDegree);
        addTableColumn(entityTable, "Last Degree", Doctor::getLastDegree);
    }
    
}
