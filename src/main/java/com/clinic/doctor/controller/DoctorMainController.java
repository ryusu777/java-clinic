package com.clinic.doctor.controller;

import java.io.IOException;

import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.stage.Stage;

public class DoctorMainController {
    public void start(Stage stage) throws IOException{        
        MedicalRecordController mRecord = new MedicalRecordController();
        CheckUpCategoryController cUCategory = new CheckUpCategoryController();
        CheckUpDetailController cUDetail = new CheckUpDetailController();
        mRecord.fetchEntitiesToTable();
        cUCategory.fetchEntitiesToTable();
        cUDetail.fetchEntitiesToTable();
        
        TabPane tabPane = new TabPane();
        Tab tab1 = new Tab("Medical Record");
        tab1.setContent(mRecord.getMainScene().getRoot());
        tab1.setStyle("-fx-pref-width: 110");
        Tab tab2 = new Tab("Check Up Category");
        tab2.setContent(cUCategory.getMainScene().getRoot());
        tab2.setStyle("-fx-pref-width: 110");
        Tab tab3 = new Tab("Check Up Detail");
        tab3.setContent(cUDetail.getMainScene().getRoot());
        tab3.setStyle("-fx-pref-width: 110");
        tabPane.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
        tabPane.getTabs().addAll(tab1, tab2, tab3);
        
        stage.setTitle("Doctor");
        stage.setScene(new Scene(tabPane, 1250, 600));
        stage.show();
    }
}
