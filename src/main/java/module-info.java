module com.clinic {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    requires transitive java.sql;

    opens com.clinic to javafx.fxml;
    exports com.clinic;
}
