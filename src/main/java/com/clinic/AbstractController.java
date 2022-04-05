package com.clinic;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.sql.SQLException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public abstract class AbstractController<T extends AbstractEntity, S extends AbstractEntityRepository<T>> {
    private Class<T> entityClass;
    private Class<S> repoClass;

    public TableView<T> entityTable;

    protected AbstractController(Class<T> entityClass, Class<S> repoClass) {
        this.entityClass = entityClass;
        this.repoClass = repoClass;
    }

    /**
     * Initialize entity data.<br>
     * Get data from database using entity repository.<br>
     * Initialize entity table to display entity data
     */
    @FXML
    public void initialize() {
        S repo = EntityRepositoryFactory.getRepository(repoClass);
        Pagination page = new Pagination();
        ObservableList<T> entities;
        try {
            entities = FXCollections.observableArrayList(repo.get(page));
            entityTable.setItems(entities);
        } catch (SQLException e) {
            System.out.println("Exception caught in AbstractController.initialize(): " + e.toString());
            return;
        }
        try {
            T entityInstance = entityClass.getConstructor(Integer.class).newInstance(0);
            TableColumn<T, Integer> idColumn = new TableColumn<>("Id");
            idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
            entityTable.getColumns().add(idColumn);
            for (Method method : repo.getEntityAttributeGetters()) {
                if (method.getName() == "getId"
                    || entityInstance.getTableFieldNames() == null 
                    || entityInstance
                        .getTableFieldNames()
                        .contains(repo.normalizeFieldName(method.getName().substring(3)))
                ) {
                    TableColumn<T, Serializable> tableColumn = new TableColumn<>(
                    method.getName().substring(3).replaceAll("([a-z])([A-Z])", "$1 $2"));
                    tableColumn.setCellValueFactory(new PropertyValueFactory<>(
                        method.getName().substring(3, 4).toLowerCase() +
                        method.getName().substring(4)
                    ));
                    entityTable.getColumns().add(tableColumn);
                }
            }
        } catch (Exception e) {
            System.out.println("Exception caught in AbstractController.initialize(): " + e.toString());
        }
    }
}
