module gui {
    requires javafx.fxml;
    requires javafx.controls;
    requires com;

    opens gui to javafx.fxml;
    exports gui to javafx.graphics;
}