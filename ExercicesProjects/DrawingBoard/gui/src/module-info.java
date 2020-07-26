module gui {
    requires javafx.fxml; // add controls to module with requires => module reads information
    requires javafx.controls;
    requires model; // add dependency to module

    opens view to javafx.fxml;
    exports view;
}