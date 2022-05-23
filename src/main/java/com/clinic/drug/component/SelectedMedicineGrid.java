package com.clinic.drug.component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.clinic.drug.domain.BaseTransactionDetail;
import com.clinic.drug.domain.MedicineStock;

import javafx.beans.binding.BooleanBinding;
import javafx.scene.layout.GridPane;

public class SelectedMedicineGrid extends GridPane {
    private List<SelectedMedicineCard> medicineList = new ArrayList<>();
    private int currentRow = 1, currentCol = 1;

    public List<BaseTransactionDetail> getTransactionDetailList() {
        List<BaseTransactionDetail> baseTransactionDetails = new ArrayList<>();
        for (SelectedMedicineCard card : medicineList) {
            baseTransactionDetails.add(card.getTransactionDetail());
        }
        return baseTransactionDetails;
    }

    public List<MedicineStock> getMedicineStockList() {
        List<MedicineStock> medicineStocks = new ArrayList<>();
        for (SelectedMedicineCard card : medicineList) {
            medicineStocks.add(card.getMedicineStock());
        }
        return medicineStocks;
    }

    public Map<BaseTransactionDetail, MedicineStock> getTransactionDetailAndStockMap() {
        Map<BaseTransactionDetail, MedicineStock> map = new LinkedHashMap<>();
        List<MedicineStock> medicineStocks = getMedicineStockList();
        List<BaseTransactionDetail> transactionDetails = getTransactionDetailList();
        for (int i = 0; i < medicineStocks.size(); i++) {
            map.put(transactionDetails.get(i), medicineStocks.get(i));
        }

        return map;
    }

    public void deleteTransactionDetail(String cardId) {
        SelectedMedicineCard cardToDelete = null;
        for (SelectedMedicineCard medicineCard : medicineList) {
            if (medicineCard.getCardId() == cardId) {
                cardToDelete = medicineCard;
                break;
            }
        }

        if (cardToDelete != null)
            medicineList.remove(cardToDelete);

        getChildren().clear();
        currentRow = 1;
        currentCol = 1;
        for (SelectedMedicineCard medicineCard : medicineList) {
            addTransactionDetail(medicineCard);
        }
    }

    public void addTransactionDetail(MedicineStock entity, BaseTransactionDetail transactionDetail, int showDetailInWhat) {
        SelectedMedicineCard card = new SelectedMedicineCard(generateId(), entity, transactionDetail, showDetailInWhat);
        medicineList.add(card);
        card.setDeleteProcedure((cardId) -> deleteTransactionDetail(cardId));
        addTransactionDetail(card);
    }

    public void addTransactionDetail(SelectedMedicineCard card) {
        add(card, currentCol, currentRow);
        incrementRowAndCol();
    }

    public String generateId() {
        return UUID.randomUUID().toString();
    };

    public void incrementRowAndCol() {
        currentCol++;
        if (currentCol > 3) {
            currentCol = 1;
            currentRow++;
        }
    }
}
