package com.clinic.drug.controller;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.clinic.drug.component.PrescriptionRecipeCard;
import com.clinic.drug.domain.PrescriptionHeader;
import com.clinic.drug.domain.PrescriptionIngredient;
import com.clinic.drug.domain.PrescriptionRecipe;
import com.clinic.drug.repository.PrescriptionHeaderRepository;
import com.clinic.drug.repository.PrescriptionIngredientRepository;
import com.clinic.drug.repository.PrescriptionRecipeRepository;
import com.clinic.factories.EntityRepositoryFactory;
import com.clinic.interfaces.IBaseController;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class PrescriptionCreationController implements IBaseController {
    MFXScrollPane scrollContainer;
    VBox mainContainer = new VBox();
    VBox recipeContainer = new VBox();
    PrescriptionHeader theHeader;
    List<PrescriptionRecipeCard> recipeCards = new ArrayList<>();
    private final String buttonStyle = "-fx-font-size: 16;" +
            "-fx-background-color: -mfx-purple;" +
            "-fx-text-fill: white;";

    private Integer doctor, patient;

    public PrescriptionCreationController(Integer doctor, Integer patient, Integer medicalRecordId) {
        this.doctor = doctor;
        this.patient = patient;
        this.theHeader = new PrescriptionHeader();
        theHeader.setCreatedDate(LocalDate.now());
        theHeader.setDoctorId(this.doctor);
        theHeader.setPatientId(this.patient);
        theHeader.setMedicalRecordId(medicalRecordId);
        initComponent();
    }

    public PrescriptionCreationController(Integer doctor, Integer patient) {
        this(doctor, patient, 0);
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

        Button savePrescriptionButton = new MFXButton("Save Prescription");
        savePrescriptionButton.setStyle(buttonStyle);
        savePrescriptionButton.setOnAction((event) -> {
            saveChanges();
        });

        mainContainer.getChildren().addAll(new Label("Doctor: "), new Label("Patient: "), recipeContainer, addPrescriptionRecipeButton, savePrescriptionButton);
        scrollContainer = new MFXScrollPane(mainContainer);
    }

    private void saveChanges() {
        int prescriptionHeaderId = 0;
        try {
            prescriptionHeaderId = EntityRepositoryFactory.getRepository(PrescriptionHeaderRepository.class).create(theHeader);
        } catch (SQLException e) {
            System.out.println("Failed to save prescription header: " + e.toString());
            return;
        }

        for (PrescriptionRecipeCard theCard : recipeCards) {
            PrescriptionRecipe recipe = theCard.getRecipe();
            recipe.setPrescriptionHeaderId(prescriptionHeaderId);
            int recipeId = 0;
            try {
                recipeId = EntityRepositoryFactory
                    .getRepository(PrescriptionRecipeRepository.class)
                    .create(recipe);
            } catch (SQLException e) {
                System.out.println("Failed to save recipe" + e.toString());
                return;
            }

            for (PrescriptionIngredient ingredient : theCard.getIngredients()) {
                ingredient.setPrescriptionRecipeId(recipeId);
                try {
                    EntityRepositoryFactory.getRepository(PrescriptionIngredientRepository.class)
                        .create(ingredient);
                } catch (SQLException e) {
                    System.out.println("Failed to save ingredient: " + e.toString());
                }
            }
        }
    }

    @Override
    public Node getNode() {
        return scrollContainer;
    }
    
}
