package calculator;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class ControllerCalculator extends AnchorPane {

    // enum to keep different types of operations before calculating
    private enum Operation {
        PLUS, MINUS, DIVIDE, MULT, NO_OP
    };

    // keep type of current operation chosen by user
    private Operation operation;

    // keep first digit before choosing operation
    private double firstInputDigit;

    // keep second entered digit
    private double secondInputDigit;

    private double result;

    // число което се пази в паметта, може да бъдат прилагани операции върху него,
    // премахва се от паметта и текстовото поле с натискане на бутона MC
    private double memoryNumber;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtInput;

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn5;

    @FXML
    private Button btn4;

    @FXML
    private Button btn6;

    @FXML
    private Button btn7;

    @FXML
    private Button btn8;

    @FXML
    private Button btn9;

    @FXML
    private Button btn0;

    @FXML
    private Button btn00;

    @FXML
    private Button btnAdd;

    @FXML
    private Button btnSubstract;

    @FXML
    private Button btnMultiply;

    @FXML
    private Button btnDivide;

    @FXML
    private Button btnCompute;

    @FXML
    private Button btnDot;

    @FXML
    private Button btnClear;

    @FXML
    private Button btnClearAll;

    @FXML
    private Button btnQuit;

    @FXML
    private Button btnM;

    @FXML
    private Button btnMPlus;

    @FXML
    private Button btnMMinus;

    @FXML
    private Button btnMClear;

    public ControllerCalculator(){
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/calculator/CalculatorFXML.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try{
            fxmlLoader.load();
        } catch (IOException exception){
            throw new RuntimeException(exception);
        }
    }

    public void setFirstInputDigit(String inputDigit){
        if(inputDigit.equals("")){
            firstInputDigit = 0;
        }
        else{
            firstInputDigit = Double.parseDouble(inputDigit);
        }
    }

    public void setSecondInputDigit(String inputDigit){
        if(inputDigit.equals("")){
            secondInputDigit = 0;
        }
        else{
            secondInputDigit = Double.parseDouble(inputDigit);
        }
    }

    public double getResult(){
        return result;
    }

    @FXML
    void btn00OnAction(ActionEvent event) {
        showDigit("00");
    }

    @FXML
    void btn0OnAction(ActionEvent event) {
        showDigit("0");
    }

    @FXML
    void btn1OnAction(ActionEvent event) {
        showDigit("1");
    }

    @FXML
    void btn2OnAction(ActionEvent event) {
        showDigit(btn2.getText());
    }

    @FXML
    void btn3OnAction(ActionEvent event) {
        showDigit("3");
    }

    @FXML
    void btn4OnAction(ActionEvent event) {
        showDigit("4");
    }

    @FXML
    void btn5OnAction(ActionEvent event) {
        showDigit("5");
    }

    @FXML
    void btn6OnAction(ActionEvent event) {
        showDigit("6");
    }

    @FXML
    void btn7OnAction(ActionEvent event) {
        showDigit("7");
    }

    @FXML
    void btn8OnAction(ActionEvent event) {
        showDigit("8");
    }

    @FXML
    void btn9OnAction(ActionEvent event) {
        showDigit("9");
    }

    private void showDigit(String digit) {
        String text = txtInput.getText();
        if (text.equals("0")) {
            txtInput.setText(digit);
        } else {
            txtInput.setText(text + digit);
        }
    }

    private void doOperation(Operation op) { // get entered digit from text field and keep operation
        setFirstInputDigit(txtInput.getText());
        operation = op;
        txtInput.setText("0");
    }

    @FXML
    void btnClearAllOnAction(ActionEvent event) {
        txtInput.setText("0");
        operation = Operation.NO_OP;
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        txtInput.setText("0");
    }

    @FXML
    void btnComputeOnAction(ActionEvent event) { // calculate result of entered digits with given operation
        setSecondInputDigit(txtInput.getText());
        switch (operation) {
            case MULT:
                result = secondInputDigit * firstInputDigit;
                break;
            case DIVIDE:
                result = firstInputDigit / secondInputDigit;
                break;
            case PLUS:
                result = secondInputDigit + firstInputDigit;
                break;
            case MINUS:
                result = firstInputDigit - secondInputDigit;
                break;
            default:
                return;
        }
        txtInput.setText("" + result);  // set result to text field as string
        operation = Operation.NO_OP;
    }

    @FXML
    void btnDivideOnAction(ActionEvent event) {
        doOperation(Operation.DIVIDE);
    }

    @FXML
    void btnDotOnAction(ActionEvent event) {
        showDigit(".");
    }

    @FXML
    void btnMultiplyOnAction(ActionEvent event) {
        doOperation(Operation.MULT);
    }

    @FXML
    void btnQuitOnAction(ActionEvent event) { // ask to quit
        if ( ButtonType.OK == messageBox()) {
            Platform.exit();
        }
    }

    // alert message box to show user appropriate message
    private ButtonType messageBox(){
        operation = Operation.NO_OP;
        Alert mb = new Alert(Alert.AlertType.CONFIRMATION);
        mb.setTitle("Quit");
        mb.setHeaderText(null);
        mb.setContentText("Do you really want to quit?");
        return mb.showAndWait().get();
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        doOperation(Operation.PLUS);
    }

    @FXML
    void btnSubstractOnAction(ActionEvent event) {
        doOperation(Operation.MINUS);
    }

    @FXML
    void btnMClearOnAction(ActionEvent event) {
        memoryNumber = 0;
        txtInput.setText("0"); // премахване на запазеното число от текстовото поле
    }

    @FXML
    void btnMMinusOnAction(ActionEvent event) {
        double resultSubstr = checkMemoryInputNumber(txtInput.getText()) - memoryNumber;
        txtInput.setText("" + resultSubstr);
    }

    @FXML
    void btnMOnAction(ActionEvent event) { // запазване на въведеното число в паметта
        memoryNumber = checkMemoryInputNumber(txtInput.getText());
    }

    @FXML
    void btnMPlusOnAction(ActionEvent event) {
        double resultSum = memoryNumber + checkMemoryInputNumber(txtInput.getText());
        txtInput.setText("" + resultSum);
    }

    private double checkMemoryInputNumber(String inputDigit){
        if(inputDigit.equals("")){
            return 0;
        }else{
            return Double.parseDouble(inputDigit);
        }
    }

    @FXML
    void initialize() {

    }
}
