package com.clinic.receptionist.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.receptionist.domain.Patient;
import com.clinic.receptionist.repository.PatientRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class PatientController extends AbstractCrudController<Patient, PatientRepository>{

    public PatientController() {
        super(Patient.class, PatientRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, Patient entity) {
        Map<String, String> items = new LinkedHashMap<>();
        items.put("Female", Patient.FEMALE);
        items.put("Male",Patient.MALE);
        
        new GridFormBuilder(formGrid)
            .addTextField("Patient Name", entity.nameProperty())
            .addTextField("No KTP", entity.noKtpProperty())
            .addLocalDateField("Date of Birth", entity.dobProperty())
            .addComboBox("Gender", entity.genderProperty(), items)
            .addTextField("Address", entity.addressProperty())
            .addTextField("Patient Phone Number", entity.telpProperty())
            .addTextField("Guardian Name", entity.guardianNameProperty())
            .addTextField("Guardian Phone Number", entity.guardianTelpProperty())
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<Patient> entityTable) {
        addTableColumn(entityTable, "Id", Patient::getId);
        addTableColumn(entityTable, "Name", Patient::getName);
        addTableColumn(entityTable, "No KTP", Patient::getNoKtp);
        addTableColumn(entityTable, "DoB", Patient::getDob);
        addTableColumn(entityTable, "Gender", Patient::getGenderDetails);
        addTableColumn(entityTable, "Address", Patient::getAddress);
        addTableColumn(entityTable, "Telp", Patient::getTelp);
        addTableColumn(entityTable, "Guardian Name", Patient::getGuardianName);
        addTableColumn(entityTable, "Guardian Telp", Patient::getGuardianTelp);
    }
    
}
