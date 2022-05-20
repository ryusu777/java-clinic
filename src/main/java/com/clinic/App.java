package com.clinic;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

import com.clinic.receptionist.controller.AppointmentController;
import com.clinic.receptionist.controller.ControlController;
import com.clinic.receptionist.controller.DoctorController;
import com.clinic.receptionist.controller.DoctorScheduleController;
import com.clinic.receptionist.controller.PatientController;
import com.clinic.receptionist.controller.QueueController;

/**
 * JavaFX App
 */
public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException{        
        QueueController queue = new QueueController();
        AppointmentController appointment = new AppointmentController();
        ControlController control = new ControlController();
        DoctorController doctor = new DoctorController();
        DoctorScheduleController doctorSchedule = new DoctorScheduleController();
        PatientController patient = new PatientController();
        queue.fetchEntitiesToTable();
        appointment.fetchEntitiesToTable();
        control.fetchEntitiesToTable();
        doctor.fetchEntitiesToTable();
        doctorSchedule.fetchEntitiesToTable();
        patient.fetchEntitiesToTable();

        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Appointment");
        tab1.setContent(appointment.getMainScene().getRoot());
        tab1.setStyle("-fx-pref-width: 110");
        Tab tab2 = new Tab("Queue");
        tab2.setContent(queue.getMainScene().getRoot());
        tab2.setStyle("-fx-pref-width: 110");
        Tab tab3 = new Tab("Control");
        tab3.setContent(control.getMainScene().getRoot());
        tab3.setStyle("-fx-pref-width: 110");
        Tab tab4 = new Tab("Doctor");
        tab4.setContent(doctor.getMainScene().getRoot());
        tab4.setStyle("-fx-pref-width: 110");
        Tab tab5 = new Tab("Patient");
        tab5.setContent(patient.getMainScene().getRoot());
        tab5.setStyle("-fx-pref-width: 110");
        Tab tab6 = new Tab("Doctor Schedule");
        tab6.setContent(doctorSchedule.getMainScene().getRoot());
        tab6.setStyle("-fx-pref-width: 110");
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(tab1, tab2, tab3, tab4, tab5, tab6);
        
        stage.setTitle("Receptionist");
        stage.setScene(new Scene(tabPane, 1250, 600));
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        ClinicConnection.connect();
        launch();
    }

}