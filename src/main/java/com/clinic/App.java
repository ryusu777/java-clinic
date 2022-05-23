package com.clinic;

import com.clinic.drug.controller.DrugMainController;

import javafx.application.Application;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        DrugMainController app = new DrugMainController();
        app.start(stage);
    }

    public static void main(String[] args) {
        ClinicConnection.connect();
        launch();
    }
}