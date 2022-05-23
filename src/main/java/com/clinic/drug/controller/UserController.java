package com.clinic.drug.controller;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.builder.GridFormBuilder;
import com.clinic.drug.domain.User;
import com.clinic.drug.repository.UserRepository;

import io.github.palexdev.materialfx.controls.MFXTableView;
import javafx.scene.layout.GridPane;

public class UserController extends AbstractCrudController<User, UserRepository> {
    public UserController() {
        super(User.class, UserRepository.class);
    }

    @Override
    protected void setFormGrid(GridPane formGrid, User entity) {
        new GridFormBuilder(formGrid)
                .addTextField("Username", entity.usernameProperty())
                .addPickField(
                        "Doctor",
                        entity.doctorIdProperty(),
                        new DosageFormCategoryController(),
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
