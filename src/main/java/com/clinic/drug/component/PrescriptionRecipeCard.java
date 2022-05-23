package com.clinic.drug.component;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Consumer;

import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.controller.DosageFormController;
import com.clinic.drug.controller.MedicineController;
import com.clinic.drug.controller.MedicineStockController;
import com.clinic.drug.controller.QtyUnitController;
import com.clinic.drug.domain.DosageForm;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.domain.MedicineStock;
import com.clinic.drug.domain.PrescriptionIngredient;
import com.clinic.drug.domain.PrescriptionRecipe;
import com.clinic.drug.domain.QtyUnit;
import com.clinic.drug.repository.DosageFormRepository;
import com.clinic.drug.repository.MedicineRepository;
import com.clinic.drug.repository.QtyUnitRepository;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PrescriptionRecipeCard extends VBox {
    GridPane prescriptionRecipeFormGrid = new GridPane();
    VBox ingredientContainer = new VBox();
    private static Consumer<String> deleteCallback;
    List<PrescriptionIngredientCard> ingredientCards = new ArrayList<>();
    private String cardId;
    private PrescriptionRecipe theRecipe = new PrescriptionRecipe();

    public static void setDeleteCallback(Consumer<String> deleteCallback) {
        PrescriptionRecipeCard.deleteCallback = deleteCallback;
    }

    private final String buttonStyle = "-fx-font-size: 16;" +
            "-fx-background-color: -mfx-purple;" +
            "-fx-text-fill: white;";

    public PrescriptionRecipeCard() {
        initComponent();
        PrescriptionIngredientCard.setDeleteCallback((cardId) -> removeIngredient(cardId));
        cardId = UUID.randomUUID().toString();
    }

    public String getCardId() {
        return cardId;
    }

    private void initComponent() {
        setPadding(new Insets(10));
        getChildren().add(new Label("R/"));
        IntegerProperty recipeTypeInForm = new SimpleIntegerProperty();
        IntegerProperty qtyInWhat = new SimpleIntegerProperty();
        Map<String, Integer> recipeTypeChoice = new LinkedHashMap<>();
        recipeTypeChoice.put("Compound", PrescriptionRecipe.COMPUND_TYPE);
        recipeTypeChoice.put("Generic", PrescriptionRecipe.GENERIC_TYPE);
        Map<String, Integer> qtyInWhatChoice = new LinkedHashMap<>();
        qtyInWhatChoice.put("In Dosage Form", SelectedMedicineCard.IN_DOSAGE_FORM);
        qtyInWhatChoice.put("In Qty Unit", SelectedMedicineCard.IN_QTY_UNIT);
        new GridFormBuilder(prescriptionRecipeFormGrid)
            .addComboBox("Recipe type", recipeTypeInForm.asObject(), recipeTypeChoice)
            .addPickField(
                "Dosage Form", 
                theRecipe.dosageFormIdProperty(), 
                CrudControllerFactory.getController(DosageFormController.class), 
                "getName")
            .addPickField(
                "Qty unit", 
                theRecipe.qtyUnitIdProperty(), 
                CrudControllerFactory.getController(QtyUnitController.class), 
                "getName")
            .addBigDecimalField("Recipe qty", theRecipe.qtyProperty())
            .addComboBox("Qty in what", qtyInWhat.asObject(), qtyInWhatChoice)
            .addTextField("Latin Usage Instruction", theRecipe.latinUsageInstructionProperty())
            .addTextField("Latin Making Instruction", theRecipe.latinMakingInstructionProperty())
            .addTextField("Usage Instruction", theRecipe.usageInstructionProperty());
        Label ingredientLabel = new Label("Ingredient");
        ingredientLabel.setStyle("-fx-font-size: 12; -fx-font-weight: bold;");
        
        Button addIngredientButton = new MFXButton("Add ingredient");
        addIngredientButton.setStyle(buttonStyle);
        addIngredientButton.setOnAction((event) -> {
            addPrescriptionIngredient();
        });

        Button deleteButton = new MFXButton("Delete recipe");
        deleteButton.setStyle("-fx-font-size: 16;" +
            "-fx-background-color: -mfx-red;" +
            "-fx-text-fill: white;");
        deleteButton.setOnAction((event) -> {
            PrescriptionRecipeCard.deleteCallback.accept(cardId);
        });
        getChildren().addAll(prescriptionRecipeFormGrid, ingredientLabel, ingredientContainer, addIngredientButton, deleteButton);
        setStyle("-fx-spacing: 10;" +
                "-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: gray;");
    }

    private void removeIngredient(String cardId) {
        PrescriptionIngredientCard cardToDelete = null;
        for (PrescriptionIngredientCard ingredientCard : ingredientCards) {
            if (ingredientCard.getCardId() == cardId) {
                cardToDelete = ingredientCard;
                break;
            }
        }

        if (cardToDelete != null) {
            ingredientCards.remove(cardToDelete);
            ingredientContainer.getChildren().remove(cardToDelete);
        }
    }

    private void addPrescriptionIngredient() {
        Medicine selectedMedicine = CrudControllerFactory
            .getController(MedicineController.class).pickEntity();
        MedicineStock selectedMedicineStock = CrudControllerFactory
            .getController(MedicineStockController.class).pickEntity("WHERE medicine_id=" + selectedMedicine.getId() + " AND qty_available > 0");
        PrescriptionIngredient newIngredient = new PrescriptionIngredient();
        newIngredient.setMedicineStockId(selectedMedicineStock.getId());
        GridPane ingredientForm = new GridPane();
        try {
            QtyUnit qtyUnit = EntityRepositoryFactory
                .getRepository(QtyUnitRepository.class)
                .get(selectedMedicineStock.getQtyUnitId());
            DosageForm dosageForm = EntityRepositoryFactory
                .getRepository(DosageFormRepository.class)
                .get(selectedMedicineStock.getDosageFormId());
            selectedMedicineStock.setQtyUnit(qtyUnit);
            selectedMedicineStock.setDosageForm(dosageForm);
            ObjectProperty<BigDecimal> qtyInForm = new SimpleObjectProperty<>();
            IntegerProperty qtyInWhat = new SimpleIntegerProperty();
            Map<String, Integer> items = new LinkedHashMap<>();
            items.put(qtyUnit.getName(), SelectedMedicineCard.IN_QTY_UNIT);
            items.put(dosageForm.getName(), SelectedMedicineCard.IN_DOSAGE_FORM);

            Stage ingredientStage = new Stage();
            Button submitIngredient = new MFXButton("Submit");
            submitIngredient.setStyle(buttonStyle);
            submitIngredient.setOnAction((event) -> {
                if (qtyInWhat.get() == SelectedMedicineCard.IN_DOSAGE_FORM) {
                    newIngredient
                            .setQty(qtyInForm.get().multiply(selectedMedicineStock.getQtyToDosageFormMultiplier()));
                } else {
                    newIngredient.setQty(qtyInForm.get());
                }

                PrescriptionIngredientCard ingredientCard = new PrescriptionIngredientCard(
                    newIngredient, 
                    selectedMedicine.getBrandName(), 
                    qtyInWhat.get() == SelectedMedicineCard.IN_DOSAGE_FORM
                    ? dosageForm.getName()
                    : qtyUnit.getShortName(),
                    qtyInForm.get().toString()
                );
                ingredientCards.add(ingredientCard);
                ingredientContainer.getChildren().add(ingredientCard);
            });

            new GridFormBuilder(ingredientForm)
                .addBigDecimalField("Qty", qtyInForm)
                .addComboBox("Qty in what", qtyInWhat.asObject(), items)
                .addButton(submitIngredient);
            ingredientStage.setScene(new Scene(ingredientForm));
            ingredientStage.showAndWait();
        } catch (SQLException e) {
            System.out.println("Exception caught in PrescriptionRecipeCard.addPrescriptionIngredient(): " + e.toString());
            return;
        }
    }
}
