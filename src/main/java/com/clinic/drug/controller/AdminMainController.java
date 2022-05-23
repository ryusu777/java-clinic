package com.clinic.drug.controller;

import java.io.IOException;
import java.util.Set;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.drug.domain.BaseTransactionDetail;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.interfaces.IBaseController;

import org.reflections.Reflections;

import io.github.palexdev.materialfx.controls.MFXRectangleToggleNode;
import io.github.palexdev.materialfx.controls.MFXScrollPane;
import io.github.palexdev.materialfx.utils.ToggleButtonsUtil;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdminMainController {
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
        setCrudMenuButton();
        layout.setCenter(CrudControllerFactory.getController(UserController.class).getMainScene().getRoot());
        stage.setScene(new Scene(layout));
        stage.show();
    }

    public void setCrudMenuButton() {
        ToggleButton controllerButton = createToggle("User data");
        controllerButton.setOnAction((event) -> {
            AbstractCrudController controller = CrudControllerFactory.getController(UserController.class);
            controller.fetchEntitiesToTable();
            Parent controllerScene = controller.getMainScene().getRoot();
            controllerScene.setStyle("-fx-background-color: #ffffff");
            layout.setCenter(controllerScene);
            controllerButton.setSelected(true);
        });
        menus.getChildren().add(controllerButton);
    }

    private ToggleButton createToggle(String text) {
        MFXRectangleToggleNode toggleNode = new MFXRectangleToggleNode(text);
        toggleNode.setMinHeight(50);
        toggleNode.setAlignment(Pos.CENTER_LEFT);
        toggleNode.setMaxWidth(Double.MAX_VALUE);
        toggleNode.setToggleGroup(toggleGroup);

        return toggleNode;
    }
}
