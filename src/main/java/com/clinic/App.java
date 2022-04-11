package com.clinic;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

import com.clinic.receptionist.controller.PatientController;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        PatientController controller = new PatientController();
        stage.setTitle("Sample Controller");
        stage.setScene(controller.getMainScene());
        controller.fetchEntitiesToTable();
        stage.show();
    }

    public static void main(String[] args) {
        ClinicConnection.connect();
        launch();
    }
}