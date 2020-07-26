package gui;

import java.net.URL;
import java.util.ResourceBundle;

import com.Functions;
import com.Tabulate;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FunctionsController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnShowSinFunction;

    @FXML
    private TextArea txaResult;

    @FXML
    private Button btnShowCosFunction;

    @FXML
    private Button btnShowTanFunction;

    @FXML
    private Button btnShowExpFunction;

    @FXML
    private Button btnQuit;

    private Tabulate tabulate;

    @FXML
    void btnQuitOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnShowCosFunctionOnAction(ActionEvent event) {
        txaResult.setText("");
        tabulate = new Tabulate(new Functions().getCosFunction());
        txaResult.setText(tabulate.tabulate(0,1,0.01));
    }

    @FXML
    void btnShowExpFunctionOnAction(ActionEvent event) {
        txaResult.setText("");
        tabulate = new Tabulate(new Functions().getExpFunction());
        txaResult.setText(tabulate.tabulate(0,1,0.01));
    }

    @FXML
    void btnShowSinFunctionOnAction(ActionEvent event) {
        txaResult.setText("");
        tabulate = new Tabulate(new Functions().getSinFunction());
        txaResult.setText(tabulate.tabulate(0,1,0.01));
    }

    @FXML
    void btnShowTanFunctionOnAction(ActionEvent event) {
        txaResult.setText("");
        tabulate = new Tabulate(new Functions().getTanFunction());
        txaResult.setText(tabulate.tabulate(0,1,0.01));
    }

    @FXML
    void initialize() {
        assert btnShowSinFunction != null : "fx:id=\"btnShowSinFunction\" was not injected: check your FXML file 'FunctionsFXML.fxml'.";
        assert txaResult != null : "fx:id=\"txaResult\" was not injected: check your FXML file 'FunctionsFXML.fxml'.";
        assert btnShowCosFunction != null : "fx:id=\"btnShowCosFunction\" was not injected: check your FXML file 'FunctionsFXML.fxml'.";
        assert btnShowTanFunction != null : "fx:id=\"btnShowTanFunction\" was not injected: check your FXML file 'FunctionsFXML.fxml'.";
        assert btnShowExpFunction != null : "fx:id=\"btnShowExpFunction\" was not injected: check your FXML file 'FunctionsFXML.fxml'.";
        assert btnQuit != null : "fx:id=\"btnQuit\" was not injected: check your FXML file 'FunctionsFXML.fxml'.";

    }
}
