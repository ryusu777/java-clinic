package com.clinic.builder;

import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.clinic.abstracts.AbstractCrudController;
import com.clinic.abstracts.AbstractEntity;
import com.clinic.extension.DateTimePicker;
import com.clinic.interfaces.Copyable;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import io.github.palexdev.materialfx.enums.FloatMode;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

/**
 * A class to help generating form fields with corresponding property to bind
 * the fields.
 * 
 * @author Jose Ryu Leonesta <jose.leonesta@student.matanauniversity.ac.id>
 */
public class GridFormBuilder {
    private int currentRow = 1;
    private GridPane formGrid;

    public GridFormBuilder(GridPane formGrid) {
        this.formGrid = formGrid;
    }

    /**
     * Adds a text field to the last row of the form grid
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     */
    public GridFormBuilder addTextField(String fieldPrompt, StringProperty property) {
        MFXTextField field = generateStyledTextField();
        field.setFloatingText(fieldPrompt);
        formGrid.addRow(currentRow, field);
        field.textProperty().bindBidirectional(property);
        currentRow++;
        return this;
    }

    /**
     * Adds a integer number field to the last row of the form grid
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     */
    public GridFormBuilder addIntegerField(String fieldPrompt, IntegerProperty property) {
        MFXTextField field = generateStyledTextField();
        field.setFloatingText(fieldPrompt);
        field.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d{0,9}")) {
                field.setText(oldVal);
            }
        });
        formGrid.addRow(currentRow, field);
        field.textProperty().bindBidirectional(property, new StringConverter<Number>() {
            @Override
            public Number fromString(String value) {
                return value.length() == 0 ? 0 : Integer.parseInt(value);
            }

            @Override
            public String toString(Number value) {
                return value == null ? "" : value.toString();
            }
        });
        currentRow++;
        return this;
    }

    /**
     * Adds a floating number field for <code>BigDecimal</code> to the last row of the form grid
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     */
    public GridFormBuilder addBigDecimalField(String fieldPrompt, Property<BigDecimal> property) {
        MFXTextField field = generateStyledTextField();
        field.setFloatingText(fieldPrompt);
        field.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                field.setText(oldVal);
            }
        });
        formGrid.addRow(currentRow, field);
        field.textProperty().bindBidirectional(property, new StringConverter<BigDecimal>() {
            @Override
            public String toString(BigDecimal value) {
                return value == null ? "" : value.toPlainString();
            }

            @Override
            public BigDecimal fromString(String value) {
                if (value.matches("\\d{0,7}([\\.])"))
                    value = value.replaceAll("[^\\d]", "");
                return value.length() == 0 ? new BigDecimal(0) : new BigDecimal(value);
            }
        });
        currentRow++;
        return this;
    }

    /**
     * Adds a date field to the last row of the form grid
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     */
    public GridFormBuilder addLocalDateField(String fieldPrompt, Property<LocalDate> property) {
        DatePicker field = new DatePicker();
        field.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            @Override 
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }

            @Override 
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        });
        formGrid.addRow(currentRow, new Label(fieldPrompt), field);
        field.valueProperty().bindBidirectional(property);
        currentRow++;
        return this;
    }

    /**
     * Adds a date time field to the last row of the form grid
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     */
    public GridFormBuilder addLocalDateTimeField(String fieldPrompt, Property<LocalDateTime> property) {
        DateTimePicker field = new DateTimePicker();
        formGrid.addRow(currentRow, new Label(fieldPrompt), field);
        field.dateTimeValueProperty().bindBidirectional(property);
        currentRow++;
        return this;
    }

    /**
     * Add a field to pick an entity from other table using their corresponding
     * controller
     * @param <T> the entity type
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     * @param controller the corresponding controller of <code>T</code>
     * @param propertyGetterMethodName the name of getter method of the picked 
     * entity to display in textfield
     */
    public <T extends AbstractEntity & Copyable<T>> GridFormBuilder addPickField(String fieldPrompt, IntegerProperty property,
            AbstractCrudController<T, ?> controller, String propertyGetterMethodName) {
        MFXTextField field = generateStyledTextField();
        field.setFloatingText(fieldPrompt);
        field.setDisable(true);
        MFXButton pickButton = new MFXButton("Pick");
        try {
            Method propertyGetterMethod = controller.getEntityClass().getMethod(propertyGetterMethodName,
                    (Class[]) null);
            T entity;
            if (property.get() == 0)
                entity = null;
            else {
                entity = controller.getRepo().get(property.get());
                field.setText(propertyGetterMethod.invoke(entity).toString());
            }
            pickButton.setOnAction(new EventHandler<ActionEvent>() {
                T localEntity = entity;

                @Override
                public void handle(ActionEvent arg0) {
                    controller.fetchEntitiesToTable();
                    localEntity = controller.pickEntity();

                    if (localEntity == null)
                        return;

                    property.set(localEntity.getId());
                    try {
                        if (propertyGetterMethod != null) {
                            field.textProperty().set(propertyGetterMethod.invoke(localEntity).toString());
                        }
                    } catch (Exception e) {
                        System.out.println("Exception caught in GridFormBuilder.addPickField(): " + e.toString());
                    }
                }
            });
        } catch (Exception e) {
            System.out.println("Exception caught in GridFormBuilder.addPickField(): " + e.toString());
        }
        formGrid.addRow(currentRow, field, pickButton);
        currentRow++;
        return this;
    }

    public GridFormBuilder addEntityGrid(AbstractCrudController<?, ?> controller) {
        formGrid.add(controller.getMainScene().getRoot(), 0, currentRow, 3, 1);
        currentRow++;
        return this;
    }

    /**
     * Adds a button to the last row of the form grid.
     *
     * Make sure to configure the buttons click handler
     * @param fieldPrompt label to display on the left of field
     * @param property property which the field should bidirect bind
     */
    public GridFormBuilder addButton(Button button) {
        formGrid.addRow(currentRow, button);
        currentRow++;
        return this;
    }

    /**
     * Generate an MFXTextField that has been styled.
     */
    private MFXTextField generateStyledTextField() {
        MFXTextField field = new MFXTextField();
        field.setPrefWidth(200);
        return field;
    }
}