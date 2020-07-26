module userjavafx {
    requires javafx.fxml;
    requires javafx.controls;
    requires users;

    opens sample to javafx.fxml;
    exports sample to javafx.graphics;
}