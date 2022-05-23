module com.clinic {
    requires transitive javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;
    requires MaterialFX;

    opens com.clinic to javafx.fxml;
    exports com.clinic;
    exports com.clinic.abstracts;
    exports com.clinic.factories;
    exports com.clinic.receptionist.domain;
    exports com.clinic.receptionist.controller;
    exports com.clinic.doctor.domain;
    exports com.clinic.doctor.controller;
}
