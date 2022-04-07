package com.clinic;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class AbstractCrudController<T extends AbstractEntity, S extends AbstractEntityRepository<T>> {
    protected final static int CREATE_ACTION = 1, UPDATE_ACTION = 2, DELETE_ACTION = 3;
    private Class<T> entityClass;
    private S repo;

    private GridPane formGrid;
    private Scene formScene;

    public TableView<T> entityTable;
    public Button updateButton;
    public Button deleteButton;

    protected AbstractCrudController(Class<T> entityClass, Class<S> repoClass) {
        this.entityClass = entityClass;
        this.repo = EntityRepositoryFactory.getRepository(repoClass);
        initFormGrid();
        formScene = new Scene(formGrid);
    }

    /**
     * Initialize entity data.<br>
     * Get data from database using entity repository.<br>
     * Initialize entity table to display entity data
     */
    @FXML
    public void initialize() {
        try {
            T entityInstance = entityClass.getConstructor(Integer.class).newInstance(0);
            fetchEntitiesToTable();
            TableColumn<T, Integer> idColumn = new TableColumn<>("Id");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            entityTable.getColumns().add(idColumn);
            for (Method method : repo.getEntityAttributeGetters()) {
                if (method.getName() == "getId"
                        || entityInstance.getTableFieldNames() == null
                        || entityInstance
                                .getTableFieldNames()
                                .contains(repo.normalizeFieldName(method.getName().substring(3)))) {
                    TableColumn<T, Serializable> tableColumn = new TableColumn<>(
                            method.getName().substring(3).replaceAll("([a-z])([A-Z])", "$1 $2"));
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(
                            method.getName().substring(3, 4).toLowerCase() +
                                    method.getName().substring(4)));
                    entityTable.getColumns().add(tableColumn);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught in AbstractController.initialize(): " + e.toString());
        }
        BooleanProperty buttonDisable = new SimpleBooleanProperty(true);
        entityTable.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<T>() {
            @Override
            public void changed(ObservableValue<? extends T> o, T oldVal, T newVal) {
                buttonDisable.setValue(newVal == null);
            }
        });
        updateButton.disableProperty().bind(buttonDisable);
        deleteButton.disableProperty().bind(buttonDisable);
    }

    @FXML
    public void showCreateForm() {
        showForm(CREATE_ACTION);
    }

    @FXML
    public void showUpdateForm() {
        showForm(UPDATE_ACTION);
    }

    @FXML
    public void showDeleteForm() {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION, "Delete data?");
        confirmation.showAndWait();
        if (confirmation.getResult() == ButtonType.OK) {
            actEntity(entityTable.getSelectionModel().getSelectedItem(), DELETE_ACTION);
            fetchEntitiesToTable();
        }
    }

    public void showForm(int action) {
        initFormGrid();
        setFormGrid(formGrid, action);
        formScene.setRoot(formGrid);
        Stage formStage = new Stage();
        formStage.setScene(formScene);
        formStage.setTitle(action == CREATE_ACTION ? "Create " : "Update " +
            entityClass.getName());
        formStage.show();
    }

    protected Button generateSubmitButton(String text, T entity, int action) {
        Button submitButton = new Button();
        submitButton.setText(text);
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                actEntity(entity, action);
                Stage stage = (Stage) submitButton.getScene().getWindow();
                stage.close();
                fetchEntitiesToTable();
            }
        });
        return submitButton;
    }

    protected void fetchEntitiesToTable() {
        ObservableList<T> entities;
        Pagination page = new Pagination();
        try {
            entities = FXCollections.observableArrayList(repo.get(page));
            entityTable.setItems(entities);
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.initialize(): " + e.toString());
        }
    }

    protected void actEntity(T entity, int action) {
        try {
            if (action == CREATE_ACTION)
                repo.create(entity);
            else if (action == UPDATE_ACTION)
                repo.edit(entity);
            else if (action == DELETE_ACTION)
                repo.delete(entity.getId());
            else
                System.out.println("Exception caught in AbstractController.actEntity(): Invalid action");
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.createEntity(): " + e.toString());
        }
    }

    private void initFormGrid() {
        formGrid = new GridPane();
        formGrid.setAlignment(Pos.CENTER);
        formGrid.setHgap(10);
        formGrid.setVgap(10);
        formGrid.setPadding(new Insets(25));
    }

    protected abstract void setFormGrid(GridPane formGrid, int action);
}
