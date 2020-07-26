module com.client {
    requires javafx.fxml;
    requires javafx.controls;
    requires com.delegate;
    requires com.geometry.types;
    requires com.geometry.utils;

    opens com.client to javafx.fxml;
    exports com.client to javafx.graphics;
}