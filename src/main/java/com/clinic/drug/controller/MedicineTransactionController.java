package com.clinic.drug.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.component.SelectedMedicineCard;
import com.clinic.drug.component.SelectedMedicineGrid;
import com.clinic.drug.domain.BaseTransactionDetail;
import com.clinic.drug.domain.BaseTransactionHeader;
import com.clinic.drug.domain.DosageForm;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.domain.MedicineStock;
import com.clinic.drug.domain.PurchaseMedicineDetail;
import com.clinic.drug.domain.PurchaseMedicineHeader;
import com.clinic.drug.domain.QtyUnit;
import com.clinic.drug.domain.SellMedicineDetail;
import com.clinic.drug.domain.SellMedicineHeader;
import com.clinic.drug.repository.DosageFormRepository;
import com.clinic.drug.repository.MedicineStockRepository;
import com.clinic.drug.repository.PurchaseMedicineDetailRepository;
import com.clinic.drug.repository.PurchaseMedicineHeaderRepository;
import com.clinic.drug.repository.QtyUnitRepository;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.factories.EntityRepositoryFactory;
import com.clinic.interfaces.IBaseController;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MedicineTransactionController implements IBaseController {
    private int transactionType;
    private Button addMedicineButton = new MFXButton("Add medicine"), 
        completeTransactionButton = new MFXButton("Complete transaction");
    private VBox mainContainer = new VBox();
    private SelectedMedicineGrid detailGrid;
    private MedicineStockController medicineStockController = CrudControllerFactory
        .getController(MedicineStockController.class);
    private MedicineController medicineController = CrudControllerFactory
        .getController(MedicineController.class);
    private BaseTransactionHeader transactionHeader;

    public MedicineTransactionController(int transactionType) {
        this.transactionType = transactionType;
        if (transactionType == BaseTransactionDetail.PURCHASE)
            this.transactionHeader = new PurchaseMedicineHeader();
        else
            this.transactionHeader = new SellMedicineHeader();
        this.transactionHeader.setPurchaseDate(LocalDate.now());

        detailGrid = new SelectedMedicineGrid();
        mainContainer.getChildren().addAll(addMedicineButton, detailGrid, completeTransactionButton);
        mainContainer.setPrefHeight(500);
        String buttonStyle = "-fx-font-size: 16;" +
                "-fx-background-color: -mfx-purple;" +
                "-fx-text-fill: white;";
        addMedicineButton.setStyle(buttonStyle);
        addMedicineButton.setOnAction((event) -> {
            try {
                addTransactionDetail();
            } catch (Exception e) {
                System.out.println(e);
            }
        });
        completeTransactionButton.setStyle(buttonStyle);
        completeTransactionButton.setOnAction((event) -> saveChanges());
    }

    public void addTransactionDetail() throws SQLException {
        String buttonStyle = "-fx-background-color: -mfx-purple;" +
                "-fx-text-fill: white;";
        Medicine selectedMedicine = medicineController.pickEntity();
        IntegerProperty showDetailInWhat = new SimpleIntegerProperty(SelectedMedicineCard.IN_QTY_UNIT);
        if (selectedMedicine == null)
            return;

        MedicineStock medicineStock;
        BaseTransactionDetail transactionDetail;
        if (transactionType == BaseTransactionDetail.PURCHASE) {
            PurchaseMedicineDetail purchaseDetail = new PurchaseMedicineDetail();
            transactionDetail = purchaseDetail;
            medicineStock = new MedicineStock();
            medicineStock.setReceivedDate(LocalDateTime.now());
            medicineStock.setMedicineId(selectedMedicine.getId());
            Button submitMedicineStockForm = new MFXButton("Submit");
            submitMedicineStockForm.setStyle(buttonStyle);
            GridPane medicineStockForm = new GridPane();
            new GridFormBuilder(medicineStockForm)
                    .addPickField(
                            "Dosage Form",
                            medicineStock.dosageFormIdProperty(),
                            CrudControllerFactory.getController(DosageFormController.class),
                            "getName")
                    .addPickField(
                            "Qty unit",
                            medicineStock.qtyUnitIdProperty(),
                            CrudControllerFactory.getController(QtyUnitController.class),
                            "getName")
                    .addBigDecimalField(
                            "Qty to dosage form multiplier",
                            medicineStock.qtyToDosageFormMultiplierProperty())
                    .addLocalDateField("Exp date", medicineStock.expDateProperty())
                    .addButton(submitMedicineStockForm);

            Stage purchaseStage = new Stage();
            purchaseStage.setScene(new Scene(medicineStockForm));

            Button submitPurchaseDetailButton = new MFXButton("Submit");
            submitPurchaseDetailButton.setStyle(buttonStyle);
            GridPane purchaseDetailForm = new GridPane();
            ObjectProperty<BigDecimal> qtyInForm = new SimpleObjectProperty<>();
            IntegerProperty pricePerUnitInForm = new SimpleIntegerProperty();
            submitMedicineStockForm.setOnAction((event) -> {
                try {
                    QtyUnit qtyUnit = EntityRepositoryFactory
                            .getRepository(QtyUnitRepository.class)
                            .get(medicineStock.getQtyUnitId());
                    DosageForm dosageForm = EntityRepositoryFactory
                            .getRepository(DosageFormRepository.class)
                            .get(medicineStock.getDosageFormId());
                    medicineStock.setQtyUnit(qtyUnit);
                    medicineStock.setDosageForm(dosageForm);
                    Map<String, Integer> items = new LinkedHashMap<>();
                    items.put(qtyUnit.getName(), SelectedMedicineCard.IN_QTY_UNIT);
                    items.put(dosageForm.getName(), SelectedMedicineCard.IN_DOSAGE_FORM);
                    new GridFormBuilder(purchaseDetailForm)
                            .addBigDecimalField("Qty", qtyInForm)
                            .addComboBox("Qty in ...", showDetailInWhat.asObject(), items)
                            .addIntegerField("Price/unit", pricePerUnitInForm)
                            .addIntegerField("HRP/unit", medicineStock.highestRetailPriceProperty())
                            .addTextField("Batch no.", medicineStock.batchNumberProperty())
                            .addButton(submitPurchaseDetailButton);
                } catch (SQLException e) {
                    System.out.println(e);
                }
                purchaseStage.setScene(new Scene(purchaseDetailForm));
            });
            submitPurchaseDetailButton.setOnAction((event) -> {
                if (showDetailInWhat.get() == SelectedMedicineCard.IN_DOSAGE_FORM) {
                    purchaseDetail
                            .setQty(qtyInForm.get().multiply(medicineStock.getQtyToDosageFormMultiplier()));
                    purchaseDetail
                            .setPricePerUnit(
                                    pricePerUnitInForm.get() / medicineStock.getQtyToDosageFormMultiplier().intValue());
                } else {
                    purchaseDetail.setQty(qtyInForm.get());
                    purchaseDetail.setPricePerUnit(pricePerUnitInForm.get());
                }
                medicineStock.setQtyAvailable(purchaseDetail.getQty());
                purchaseStage.close();
            });
            purchaseStage.showAndWait();
        } else {
            SellMedicineDetail sellDetail = new SellMedicineDetail();
            transactionDetail = sellDetail;
            medicineStock = medicineStockController.pickEntity("WHERE medicine_id=" + selectedMedicine.getId());
        }
        medicineStock.setMedicine(selectedMedicine);
        if (medicineStock != null && transactionDetail != null)
            detailGrid.addTransactionDetail(medicineStock, transactionDetail, showDetailInWhat.get());
    }

    public void saveChanges() {
        if (transactionType == BaseTransactionDetail.PURCHASE) {
            savePurchaseTransaction(detailGrid.getTransactionDetailAndStockMap());
        }
    }

    public void savePurchaseTransaction(Map<BaseTransactionDetail, MedicineStock> transactionAndStockMap) {
        PurchaseMedicineHeader purchaseHeader = (PurchaseMedicineHeader) transactionHeader;
        PurchaseMedicineHeaderRepository purchaseHeaderRepo = EntityRepositoryFactory
            .getRepository(PurchaseMedicineHeaderRepository.class);
        PurchaseMedicineDetailRepository purchaseDetailRepo = EntityRepositoryFactory
            .getRepository(PurchaseMedicineDetailRepository.class);
        MedicineStockRepository medicineStockRepo = EntityRepositoryFactory.getRepository(MedicineStockRepository.class);
        int purchaseHeaderId = -1;
        try {
            purchaseHeaderId = purchaseHeaderRepo.create(purchaseHeader);
        } catch (SQLException e) {
            System.out.println(e);
            Alert errorAlert = new Alert(AlertType.ERROR);
            errorAlert.setContentText("Failed to save purchase header");
            errorAlert.showAndWait();
            return;
        }

        for (BaseTransactionDetail baseDetail : transactionAndStockMap.keySet()) {
            PurchaseMedicineDetail purchaseDetail = (PurchaseMedicineDetail) baseDetail;
            MedicineStock medicineStock = transactionAndStockMap.get(purchaseDetail);
            purchaseDetail.setPurchaseMedicineHeaderId(purchaseHeaderId);
            try {
                int purchaseDetailId = purchaseDetailRepo.create(purchaseDetail);
                medicineStock.setPurchaseMedicineDetailId(purchaseDetailId);
            } catch (SQLException e) {
                System.out.println(e);
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setContentText("Failed to save purchase header");
                errorAlert.showAndWait();
                return;
            }

            try {
                medicineStockRepo.create(medicineStock);
            } catch (SQLException e) {
                System.out.println(e);
                Alert errorAlert = new Alert(AlertType.ERROR);
                errorAlert.setContentText("Failed to save medicine stock");
                errorAlert.showAndWait();
                return;
            }
        }
    }

    @Override
    public Node getNode() {
        return mainContainer;
    }
}
