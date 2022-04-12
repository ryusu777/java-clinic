package com.clinic.doctor.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.doctor.domain.MedicalRecord;
import com.clinic.doctor.repository.MedicalRecordRepository;
import com.clinic.factories.CrudControllerFactory;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MedicalRecordController extends AbstractCrudController<MedicalRecord, MedicalRecordRepository>{
    public MedicalRecordController() {
        super(MedicalRecord.class, MedicalRecordRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, MedicalRecord entity) {
        new GridFormBuilder(formGrid)
            // .addPickField("Patient ID: ", entity.patientIdProperty(),CrudControllerFactory.getController(PatientController.class), "getName")
            .addLocalDateField("Check Up Date: ", entity.checkUpDateProperty())
            .addTextField("Symptom: ", entity.symptomProperty())
            .addTextField("Treatment: ", entity.treatmentProperty())
            // .addPickField("Doctor ID: ", entity.doctorIdProperty(),CrudControllerFactory.getController(DoctorController.class), "getName")
            // .addPickField("Prescription Header ID: ", entity.prescriptionHeaderIdProperty(),CrudControllerFactory.getController(PrescriptionHeaderController.class), "getName")
            .addButton(generateSubmitButton("Submit", entity));
    }
}
