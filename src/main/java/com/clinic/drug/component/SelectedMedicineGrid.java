package com.clinic.drug.component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.clinic.drug.domain.BaseTransactionDetail;
import com.clinic.drug.domain.MedicineStock;

import javafx.scene.layout.GridPane;

public class SelectedMedicineGrid extends GridPane {
    private List<SelectedMedicineCard> medicineList = new ArrayList<>();
    private int currentRow = 1, currentCol = 1;

    public List<BaseTransactionDetail> getTransactionDetailList() {
        return null;
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
