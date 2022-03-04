package com.clinic;

import java.sql.SQLException;
import java.util.List;
import com.clinic.drug.domain.Medicine;
import com.clinic.drug.repository.MedicineRepository;

public class Test {
    private static MedicineRepository repo;

    public static void main(String[] args) {
        ClinicConnection.connect();
        repo = new MedicineRepository();
        Pagination page = new Pagination();
        page.recordsPerPage = 2;

        try {
            List<Medicine> medicines = repo.get(page);
            System.out.print(page.totalRecords);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private static void printMedicine(Medicine entity) {
        System.out.println("Id: " + entity.getId());
        System.out.println("Brand Name: " + entity.getBrandName());
        System.out.println("Generic Name: " + entity.getGenericName());
        System.out.println("Dosage Form Id: " + entity.getDosageFormId());
        System.out.println("Qty Unit Id: " + entity.getQtyUnitId());
    }

    private static void printMedicines(List<Medicine> medicines) {
        System.out.printf("%-3s | %-20s | %-30s | %-7s | %-8s\n", "Id", "B. Name", "G. Name", "Do. Id", "Qty. Id");
        for (Medicine m : medicines) {
            System.out.printf("%-3d | %-20s | %-30s | %-7d | %-8d\n",
                    m.getId(),
                    m.getBrandName(),
                    m.getGenericName(),
                    m.getDosageFormId(),
                    m.getQtyUnitId()
                );
        }
    }
}
