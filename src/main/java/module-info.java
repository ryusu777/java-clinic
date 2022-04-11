module com.clinic {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;

    opens com.clinic to javafx.fxml;
    exports com.clinic;
    exports com.clinic.abstracts;
    exports com.clinic.factories;
    exports com.clinic.receptionist.domain;
    exports com.clinic.receptionist.controller;
}
