package com.clinic.drug.controller;

import com.clinic.AbstractController;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.repository.MedicineRepository;

public class MedicineController extends AbstractController<Medicine, MedicineRepository>{
    public MedicineController() {
        super(Medicine.class, MedicineRepository.class);
    }
}
