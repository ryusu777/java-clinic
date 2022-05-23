package com.clinic.doctor.controller;

import java.sql.SQLException;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.doctor.domain.CheckUpDetail;
import com.clinic.doctor.domain.MedicalRecord;
import com.clinic.doctor.repository.CheckUpDetailRepository;
import com.clinic.doctor.repository.MedicalRecordRepository;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;
import com.clinic.receptionist.controller.DoctorController;
import com.clinic.receptionist.controller.PatientController;
import com.clinic.receptionist.repository.DoctorRepository;
import com.clinic.receptionist.repository.PatientRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MedicalRecordController extends AbstractCrudController<MedicalRecord, MedicalRecordRepository>{
    public MedicalRecordController() {
        super(MedicalRecord.class, MedicalRecordRepository.class, "MEDICAL RECORD");
    }

    @Override
    protected void setFormGrid(GridPane formGrid, MedicalRecord entity) {
        new GridFormBuilder(formGrid)
            .addPickField("Patient ID: ", entity.patientIdProperty(),CrudControllerFactory.getController(PatientController.class), "getName")
            .addLocalDateField("Check Up Date: ", entity.checkUpDateProperty())
            .addTextField("Symptom: ", entity.symptomProperty())
            .addTextField("Treatment: ", entity.treatmentProperty())
            .addPickField("Doctor ID: ", entity.doctorIdProperty(),CrudControllerFactory.getController(DoctorController.class), "getName")
            // .addPickField("Prescription Header ID: ", entity.prescriptionHeaderIdProperty(),CrudControllerFactory.getController(PrescriptionHeaderController.class), "getName")
            .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    public void fetchEntitiesToTable(MFXTableView<MedicalRecord> entityTable, String whereClause) {
        ObservableList<MedicalRecord> entities;
        try {
            entities = FXCollections.observableArrayList(repo.join(EntityRepositoryFactory.getRepository(DoctorRepository.class), EntityRepositoryFactory.getRepository(PatientRepository.class), "doctor_id", "patient_id"));
            entityTable.setItems(entities);
            entityTable.autosize();
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.fetchEntitiesToTable(): " + e.toString());
        }
    }

    @Override 
    protected void initTableViewSchema(MFXTableView<MedicalRecord> entityTable) {
        addTableColumn(entityTable, "Id", MedicalRecord::getId);
        addTableColumn(entityTable, "Patient Id", MedicalRecord::getPatientId);
        addTableColumn(entityTable, "Doctor Id", MedicalRecord::getDoctorId);
        addTableColumn(entityTable, "Prescription Id", MedicalRecord::getPrescriptionHeaderId);
        addTableColumn(entityTable, "Symptom", MedicalRecord::getSymptom);
        addTableColumn(entityTable, "Treatment", MedicalRecord::getTreatment); 
        addTableColumn(entityTable, "Check Up Date", MedicalRecord::getCheckUpDate);
    }
}
