package com.clinic.drug.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.clinic.drug.component.PrescriptionRecipeCard;
import com.clinic.drug.domain.PrescriptionHeader;
import com.clinic.interfaces.IBaseController;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrescriptionCreationController implements IBaseController {
    VBox mainContainer = new VBox();
    VBox recipeContainer = new VBox();
    PrescriptionHeader theHeader;
    List<PrescriptionRecipeCard> recipeCards = new ArrayList<>();
    private final String buttonStyle = "-fx-font-size: 16;" +
            "-fx-background-color: -mfx-purple;" +
            "-fx-text-fill: white;";

    private Integer doctor, patient, medicalRecordId;

    public PrescriptionCreationController(Integer doctor, Integer patient, Integer medicalRecordId) {
        this.doctor = doctor;
        this.patient = patient;
        this.theHeader = new PrescriptionHeader();
        theHeader.setCreatedDate(LocalDate.now());
        theHeader.setDoctorId(this.doctor);
        theHeader.setPatientId(this.patient);
        initComponent();
    }

    public PrescriptionCreationController(Integer doctor, Integer patient) {
        this(doctor, patient, null);
    }

    private void initComponent() {
        mainContainer.setSpacing(10);
        mainContainer.setPadding(new Insets(10));
        recipeContainer.setSpacing(10);
        recipeContainer.setPadding(new Insets(10));

        Button addPrescriptionRecipeButton = new MFXButton("Add recipe");
        addPrescriptionRecipeButton.setStyle(buttonStyle);
        addPrescriptionRecipeButton.setOnAction((event) -> {
            PrescriptionRecipeCard newRecipe = new PrescriptionRecipeCard();
            recipeCards.add(newRecipe);
            recipeContainer.getChildren().addAll(newRecipe);
        });

        mainContainer.getChildren().addAll(new Label("Doctor: "), new Label("Patient: "), recipeContainer, addPrescriptionRecipeButton);
    }

    @Override
    public Node getNode() {
        return mainContainer;
    }
    
}
