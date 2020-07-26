module gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires model;

    opens gui to javafx.fxml;
    exports gui to javafx.graphics;
}