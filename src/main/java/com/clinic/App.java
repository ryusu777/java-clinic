package com.clinic;

import javafx.application.Application;
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
    public void start(Stage stage) throws IOException{        
        
    }

    public static void main(String[] args) throws SQLException {
        ClinicConnection.connect();
        launch();
    }

}