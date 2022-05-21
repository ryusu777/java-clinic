package com.clinic.drug.component;

import java.math.BigDecimal;
import java.util.function.Consumer;

import com.clinic.drug.domain.BaseTransactionDetail;
import com.clinic.drug.domain.MedicineStock;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SelectedMedicineCard extends VBox {
    public final static int IN_DOSAGE_FORM = 0, IN_QTY_UNIT = 1;
    private MedicineStock entity;
    private BaseTransactionDetail transactionDetail;
    private String cardId;
    private int showDetailInWhat;
    private Label genericNameValueLabel = new Label(),
        brandNameValueLabel = new Label(),
        dosageFormValueLabel = new Label(),
        qtyValueLabel = new Label(),
        pricePerUnitValueLabel = new Label(),
        subTotalValueLabel = new Label();

    private ObjectProperty<BigDecimal> subTotal = new SimpleObjectProperty<>();
    private ObjectProperty<BigDecimal> qty = new SimpleObjectProperty<>();
    private IntegerProperty pricePerUnit = new SimpleIntegerProperty();

    private Consumer<String> deleteProcedure;

    public SelectedMedicineCard(String cardId, MedicineStock entity, BaseTransactionDetail transactionDetail, int showDetailInWhat) {
        this(entity, showDetailInWhat);
        this.cardId = cardId;
        this.transactionDetail = transactionDetail;
        if (showDetailInWhat == SelectedMedicineCard.IN_DOSAGE_FORM) {
            qty.setValue(transactionDetail.getQty().multiply(entity.getQtyToDosageFormMultiplier()));
            pricePerUnit.setValue(transactionDetail.getPricePerUnit() / entity.getQtyToDosageFormMultiplier().intValue());
        } else {
            qty.bind(this.transactionDetail.qtyProperty());
            pricePerUnit.bind(this.transactionDetail.pricePerUnitProperty());
        }
    }

    private SelectedMedicineCard(MedicineStock entity, int showDetailInWhat) {
        this.entity = entity;
        this.showDetailInWhat = showDetailInWhat;
        qty.addListener((obs, oldValue, newValue) -> subTotal.setValue(newValue.multiply(BigDecimal.valueOf(pricePerUnit.get()))));
        pricePerUnit.addListener((obs, oldValue, newValue) -> subTotal.setValue(qty.get().multiply(BigDecimal.valueOf(newValue.longValue()))));
        brandNameValueLabel.textProperty().bind(this.entity.getMedicine().brandNameProperty());
        genericNameValueLabel.textProperty().bind(this.entity.getMedicine().genericNameProperty());
        dosageFormValueLabel.textProperty().bind(this.entity.getDosageForm().nameProperty());
        qtyValueLabel.textProperty().bind(qty.asString()
            .concat(showDetailInWhat == SelectedMedicineCard.IN_DOSAGE_FORM 
                ? " " + entity.getDosageForm().getName()
                : " " + entity.getQtyUnit().getShortName()));
        pricePerUnitValueLabel.textProperty().bind(pricePerUnit.asString());
        subTotalValueLabel.textProperty().bind(subTotal.asString());
        initComponent();
    }

    private void initComponent() {
        VBox nameContainer = new VBox(brandNameValueLabel, genericNameValueLabel);
        GridPane detailContainer = new GridPane();
        detailContainer.addRow(1, new Label("Qty"), new Label(":"), qtyValueLabel);
        detailContainer.addRow(2, new Label("Price/unit"), new Label(":"), pricePerUnitValueLabel);
        detailContainer.addRow(3, new Label("Subtotal"), new Label(":"), subTotalValueLabel);
        detailContainer.setPrefWidth(Double.MAX_VALUE);

        Button deleteButton = new MFXButton("Delete");
        deleteButton.setOnAction((event) -> {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Delete data?");
            confirmation.showAndWait();
            if (confirmation.getResult() == ButtonType.OK) {
                deleteProcedure.accept(cardId);
            }
        });
        deleteButton.setStyle("-fx-font-size: 14; -fx-background-color: -mfx-red; -fx-text-fill: white");
        HBox actionContainer = new HBox(deleteButton);
        actionContainer.setSpacing(10);
        actionContainer.setAlignment(Pos.BASELINE_RIGHT);

        getChildren().addAll(nameContainer, detailContainer, actionContainer);
        setPrefHeight(150);
        setPrefWidth(200);
        brandNameValueLabel.setStyle("-fx-font-size: 14;" + 
                "-fx-font-weight: bold;");
        genericNameValueLabel.setStyle("-fx-font-size: 12;" + 
                "-fx-font-weight: bold;");
        setStyle("-fx-spacing: 10;" +
                "-fx-padding: 10;" + 
                "-fx-border-style: solid inside;" + 
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" + 
                "-fx-border-radius: 5;" + 
                "-fx-border-color: gray;");
    }

    public void setDeleteProcedure(Consumer<String> consumer) {
        deleteProcedure = consumer;
    }

    public String getCardId() {
        return cardId;
    }

    public MedicineStock getMedicineStock() {
        return entity;
    }

    public SelectedMedicineCard setMedicineStock(MedicineStock entity) {
        this.entity = entity;
        return this;
    }

    public BaseTransactionDetail getTransactionDetail() {
        return transactionDetail;
    }

    public SelectedMedicineCard setTransactionDetail(BaseTransactionDetail transactionDetail) {
        this.transactionDetail = transactionDetail;
        return this;
    }
}
