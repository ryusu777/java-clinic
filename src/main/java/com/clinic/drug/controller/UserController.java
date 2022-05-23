package com.clinic.drug.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.User;
import com.clinic.drug.repository.UserRepository;
import com.clinic.factories.CrudControllerFactory;
import com.clinic.receptionist.controller.DoctorController;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class UserController extends AbstractCrudController<User, UserRepository> {
    public UserController() {
        super(User.class, UserRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, User entity) {
        Map<String, Integer> userRoleChoice = new LinkedHashMap<>();
        userRoleChoice.put("Admin", User.ADMIN);
        userRoleChoice.put("Doctor", User.DOCTOR);
        userRoleChoice.put("Pharmacist", User.PHARMACIST);
        userRoleChoice.put("Receptionist", User.RECEPTIONIST);

        new GridFormBuilder(formGrid)
                .addTextField("Username", entity.usernameProperty())
                .addTextField("Password", entity.passwordProperty())
                .addComboBox("Role", entity.userRoleProperty().asObject(), userRoleChoice)
                .addPickField(
                        "Doctor",
                        entity.doctorIdProperty(),
                        CrudControllerFactory.getController(DoctorController.class),
                        "getName")
                .addButton(generateSubmitButton("Submit", entity));
    }

    @Override
    protected void initTableViewSchema(MFXTableView<User> entityTable) {
        addTableColumn(entityTable, "Id", User::getId);
        addTableColumn(entityTable, "Username", User::getUsername);
        addTableColumn(entityTable, "Doctor Id", User::getDoctorId);
    }
}
