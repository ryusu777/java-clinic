package com.clinic;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.clinic.builder.GridFormBuilder;
import com.clinic.doctor.controller.DoctorMainController;
import com.clinic.drug.controller.AdminMainController;
import com.clinic.drug.controller.DrugMainController;
import com.clinic.drug.domain.User;
import com.clinic.drug.repository.UserRepository;
import com.clinic.factories.EntityRepositoryFactory;
import com.clinic.receptionist.controller.ReceptionistMainController;

import io.github.palexdev.materialfx.controls.MFXButton;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        StringProperty username = new SimpleStringProperty();
        StringProperty password = new SimpleStringProperty();
        GridPane loginForm = new GridPane();
        Button loginButton = new MFXButton("Login");
        Label loginLabel = new Label("Login");
        VBox loginContainer = new VBox();
        loginContainer.setPadding(new Insets(20));
        loginContainer.setAlignment(Pos.CENTER);
        loginButton.setOnAction((event) -> {
            try {
                ResultSet userResult = ClinicConnection.query("SELECT * FROM user WHERE username LIKE '" + username.get() + "' AND password LIKE '" + password.get() + "';");
                if (!userResult.next()) {
                    loginLabel.setText("Credential not correct");
                    return;
                }
                User user = EntityRepositoryFactory
                    .getRepository(UserRepository.class)
                    .mapEntity(userResult);

                if (user.getUserRole() == User.PHARMACIST) {
                    new DrugMainController().start(stage);;
                } else if (user.getUserRole() == User.RECEPTIONIST) {
                    new ReceptionistMainController().start(stage);;
                } else if (user.getUserRole() == User.DOCTOR) {
                    new DoctorMainController().start(stage);;
                } else if (user.getUserRole() == User.ADMIN) {
                    new AdminMainController().start(stage);;
                }
            } catch (SQLException | IOException e) {
                System.out.println("Failed to do user query");
                return;
            }

        });

        new GridFormBuilder(loginForm)
            .addTextField("Username", username)
            .addTextField("Password", password)
            .addButton(loginButton);

        loginContainer.getChildren().addAll(loginLabel, loginForm);
        stage.setScene(new Scene(loginContainer));
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        ClinicConnection.connect();
        launch();
    }

}