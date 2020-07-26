package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane apCalculator;

    @FXML
    void initialize() {
        assert apCalculator != null : "fx:id=\"apCalculator\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
