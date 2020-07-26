package sample;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import user.User;

public class Controller {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    private Alert messageBox;

    private BooleanProperty accessGranted;

    private User user;

    @FXML
    void txtPasswordOnAction(ActionEvent event) {
        if(accessGranted.get()) {
            messageBox.setTitle("Message");
            messageBox.setHeaderText("Login information.");
            messageBox.setContentText(String.format("LastName: %s%nPassword: %s", txtUsername.getText(), txtPassword.getText()));
            messageBox.showAndWait();
        }
    }

    @FXML
    void initialize(){
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        accessGranted = new SimpleBooleanProperty(this, "accessGranted", false);
        user = new User();

        txtUsername.textProperty().bind(user.lastNameProperty());

        txtPassword.textProperty().addListener((observableValue, oldValue, newValue) -> {
            accessGranted.set(user.getPassword().equals(newValue));
        });

        accessGranted.addListener((observableValue, oldValue, newValue) -> {
            Stage primaryStage = (Stage) txtPassword.getScene().getWindow();
            if(newValue){
                primaryStage.setTitle("Access granted");
            } else{
                primaryStage.setTitle("No access");
            }
        });

    }
}
