package com.clinic.drug.component;

import java.util.UUID;
import java.util.function.Consumer;

import com.clinic.drug.domain.PrescriptionIngredient;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.enums.FloatMode;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.HBox;

public class PrescriptionIngredientCard extends HBox {
    private PrescriptionIngredient ingredient;
    private String brandName;
    private String cardId;
    private static Consumer<String> deleteCallback;
    private String qtyInWhat;

    public static void setDeleteCallback(Consumer<String> deleteCallback) {
        PrescriptionIngredientCard.deleteCallback = deleteCallback;
    }

    public PrescriptionIngredientCard(PrescriptionIngredient ingredient, String brandName, String qtyInWhat, String qtyToShow) {
        this.ingredient = ingredient;
        this.brandName = brandName;
        this.qtyInWhat = qtyInWhat;
        this.cardId = UUID.randomUUID().toString();
        initComponent();
    }

    public PrescriptionIngredient getPrescriptionIngredient() {
        return ingredient;
    }

    public String getCardId() {
        return cardId;
    }

    private void initComponent() {
        setSpacing(20);

        MFXTextField brandNameField = new MFXTextField("Brand Name");
        brandNameField.setPrefWidth(200);
        brandNameField.setFloatMode(FloatMode.DISABLED);
        brandNameField.setText(brandName);
        brandNameField.setDisable(true);
        MFXTextField qtyField = new MFXTextField("Brand Name");
        qtyField.setPrefWidth(100);
        qtyField.setText(ingredient.getQty().toString() + " " + qtyInWhat);
        qtyField.setFloatMode(FloatMode.DISABLED);
        qtyField.setDisable(true);
        Button deleteButton = new MFXButton("Delete");
        deleteButton.setOnAction((event) -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Delete data?");
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                PrescriptionIngredientCard.deleteCallback.accept(cardId);
            }
        });
        deleteButton.setStyle("-fx-font-size: 14; -fx-background-color: -mfx-red; -fx-text-fill: white");

        getChildren().addAll(brandNameField, qtyField, deleteButton);
    }
}
