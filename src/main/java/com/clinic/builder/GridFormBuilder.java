package com.clinic.builder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.clinic.extension.DateTimePicker;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.Property;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;

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
        TextField field = new TextField();
        formGrid.addRow(currentRow, new Label(fieldPrompt), field);
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
        TextField field = new TextField();
        field.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d{0,9}")) {
                field.setText(oldVal);
            }
        });
        formGrid.addRow(currentRow, new Label(fieldPrompt), field);
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
        TextField field = new TextField();
        field.textProperty().addListener((observable, oldVal, newVal) -> {
            if (!newVal.matches("\\d{0,7}([\\.]\\d{0,4})?")) {
                field.setText(oldVal);
            }
        });
        formGrid.addRow(currentRow, new Label(fieldPrompt), field);
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
}