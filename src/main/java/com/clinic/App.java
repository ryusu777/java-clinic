package com.clinic;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.clinic.doctor.controller.MedicalRecordController;
import com.clinic.doctor.repository.MedicalRecordRepository;
import com.clinic.doctor.domain.MedicalRecord;
import com.clinic.doctor.controller.CheckUpCategoryController;
import com.clinic.doctor.repository.CheckUpCategoryRepository;
import com.clinic.doctor.domain.CheckUpCategory;
import com.clinic.doctor.controller.CheckUpDetailController;
import com.clinic.doctor.repository.CheckUpDetailRepository;
import com.clinic.doctor.domain.CheckUpDetail;
import com.clinic.factories.EntityRepositoryFactory;
/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        MedicalRecordController medicalRecord = new MedicalRecordController();
        CheckUpCategoryController checkUpCategory = new CheckUpCategoryController();
        CheckUpDetailController checkUpDetail = new CheckUpDetailController();

        medicalRecord.fetchEntitiesToTable();
        checkUpCategory.fetchEntitiesToTable();
        checkUpDetail.fetchEntitiesToTable();

        TabPane tabPane = new TabPane();
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);

        Tab tab1 = new Tab("Medical Record");
        stage.setTitle("Medical Record");
        tab1.setContent(medicalRecord.getMainScene().getRoot());
        
        Tab tab2 = new Tab("Check Up Category");
        stage.setTitle("Check Up Category");
        tab2.setContent(checkUpCategory.getMainScene().getRoot());

        Tab tab3 = new Tab("Check Up Detail");
        stage.setTitle("Check Up Detail");
        tab3.setContent(checkUpDetail.getMainScene().getRoot());
        
        tabPane.getTabs().addAll(tab1, tab2, tab3);

        // MedicalRecordController controller = new MedicalRecordController();
        // CheckUpCategoryController controller = new CheckUpCategoryController();
        // CheckUpDetailController controller = new CheckUpDetailController();
        // stage.setTitle("Medical Record");
        // stage.setTitle("Check Up Category");
        // stage.setTitle("Check Up Detail");
        stage.setScene(new Scene(tabPane));
        // controller.fetchEntitiesToTable();
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        ClinicConnection.connect();
        launch();
        // MedicalRecordRepository repo = EntityRepositoryFactory.getRepository(MedicalRecordRepository.class);
        // repo.search(new Pagination(), "radiologi");
        // for (MedicalRecord field : repo.search(new Pagination(), "Fever")) {
        //     System.out.println(field.symptomProperty());
        // }
    }
}