package com.clinic.drug.controller;

import java.io.IOException;
import java.util.Set;

import com.clinic.ClinicConnection;
import com.clinic.abstracts.AbstractCrudController;
import com.clinic.drug.domain.BaseTransactionDetail;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.interfaces.IBaseController;

import org.reflections.Reflections;

import io.github.palexdev.materialfx.controls.MFXRectangleToggleNode;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.utils.ToggleButtonsUtil;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DrugMainController {
    private VBox menus = new VBox();
    private MFXScrollPane navbarPane = new MFXScrollPane(menus);
    private BorderPane layout = new BorderPane();
    private ToggleGroup toggleGroup;

    public void start(Stage stage) throws IOException {
        menus.setPrefWidth(300);
        menus.setSpacing(10);
        navbarPane.setPadding(new Insets(10));
        navbarPane.setPrefWidth(340);
        layout.setLeft(navbarPane);
        layout.setPrefHeight(600);
        layout.setPrefWidth(1000);
        layout.setStyle("-fx-background-color: #ffffff");
		this.toggleGroup = new ToggleGroup();
		ToggleButtonsUtil.addAlwaysOneSelectedSupport(toggleGroup);
        // setCrudMenuButton("com.clinic.drug.controller");
        setMenuButtons();
        layout.setCenter(new MedicineTransactionController(BaseTransactionDetail.PURCHASE).getNode());
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public void setMenuButtons() {
        menus.getChildren().add(createToggleControllerButton("Purchase Medicine",
                new MedicineTransactionController(BaseTransactionDetail.PURCHASE)));
        menus.getChildren().add(createToggleControllerButton("Sell Medicine",
                new MedicineTransactionController(BaseTransactionDetail.SELL)));
        menus.getChildren().add(createToggleControllerButton("Create Prescription",
                new PrescriptionCreationController(0, 0)));
    }

    public void setCrudMenuButton(String packageName) {
        for (Class<? extends AbstractCrudController> controllerClass : findAllClassesInPackage(
                packageName)) {
            ToggleButton controllerButton = createToggle(controllerClass.getSimpleName());
            controllerButton.setOnAction((event) -> {
                AbstractCrudController controller = CrudControllerFactory.getController(controllerClass);
                controller.fetchEntitiesToTable();
                Parent controllerScene = controller.getMainScene().getRoot();
                controllerScene.setStyle("-fx-background-color: #ffffff");
                layout.setCenter(controllerScene);
                controllerButton.setSelected(true);
            });
            menus.getChildren().add(controllerButton);
        }
    }

    private Set<Class<? extends AbstractCrudController>> findAllClassesInPackage(String packageName) {
        return new Reflections(packageName).getSubTypesOf(AbstractCrudController.class);
    }

    private ToggleButton createToggle(String text) {
        MFXRectangleToggleNode toggleNode = new MFXRectangleToggleNode(text);
        toggleNode.setMinHeight(50);
        toggleNode.setAlignment(Pos.CENTER_LEFT);
        toggleNode.setMaxWidth(Double.MAX_VALUE);
        toggleNode.setToggleGroup(toggleGroup);

        return toggleNode;
    }

    private ToggleButton createToggleControllerButton(String text, IBaseController controller) {
        MFXRectangleToggleNode toggleNode = new MFXRectangleToggleNode(text);
        toggleNode.setMinHeight(50);
        toggleNode.setAlignment(Pos.CENTER_LEFT);
        toggleNode.setMaxWidth(Double.MAX_VALUE);
        toggleNode.setToggleGroup(toggleGroup);
        toggleNode.setOnAction((event) -> {
            layout.setCenter(controller.getNode());
            toggleNode.setSelected(true);
        });

        return toggleNode;
    }
}
