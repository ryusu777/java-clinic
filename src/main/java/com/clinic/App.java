package com.clinic;

import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

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