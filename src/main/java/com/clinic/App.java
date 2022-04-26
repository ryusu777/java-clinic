package com.clinic;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.clinic.doctor.controller.MedicalRecordController;
import com.clinic.doctor.controller.CheckUpCategoryController;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // MedicalRecordController controller = new MedicalRecordController();
        CheckUpCategoryController controller = new CheckUpCategoryController();
        controller.fetchEntitiesToTable();
        stage.setScene(controller.getMainScene());
        stage.setTitle("Medical Record");
        stage.setTitle("Check Up Category");
        stage.show();
    }

    public static void main(String[] args) {
        ClinicConnection.connect();
        launch();
    }
}