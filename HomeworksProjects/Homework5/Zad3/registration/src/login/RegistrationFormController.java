package login;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import validator.Validator;

public class RegistrationFormController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblWrongUsername;

    @FXML
    private TextField txtUsername;

    @FXML
    private Label lblWrongPhone;

    @FXML
    private TextField txtPhone;

    @FXML
    private Label lblWrongEmail;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label lblWrongPassword;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblWrongConfPassword;

    @FXML
    private PasswordField txtConfirmPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private Label lblPhone;

    @FXML
    private Label lblEmail;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblConfirmPassword;

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnCancel;

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void btnLoginOnAction(ActionEvent event) {
        if(validateInput()){
            clearWrongLabels(); // изчиства появилите се съобщения за грешни данни когато потребителят въведе правилна информация
            messageBox("Success", "Successful registration!"); // показване на Alert message box при успешна регистрация
        }
    }

    private void clearWrongLabels(){
        lblWrongUsername.setText("");
        lblWrongPhone.setText("");
        lblWrongEmail.setText("");
        lblWrongPassword.setText("");
        lblWrongConfPassword.setText("");
    }

    private boolean validateInput(){ // проверка на въведените данни чрез методите на класа Validator в модула validation

        if(Validator.validateEmpty(txtUsername.getText(), txtPhone.getText(), txtEmail.getText(), txtPassword.getText(), txtConfirmPassword.getText())){
            lblWrongUsername.setText("Fields cannot be empty!");
            return false;
        }

        boolean isValidUsername = Validator.validateUsername(txtUsername.getText());
        boolean isValidPhone = Validator.validatePhone(txtPhone.getText());
        boolean isValidEmail = Validator.validateEmail(txtEmail.getText());
        boolean isValidPassword = Validator.validatePassword(txtPassword.getText());
        boolean isValidConfirmPassword = Validator.validateConfirmPassword(txtPassword.getText(), txtConfirmPassword.getText());

        // извеждане на съответните съобщения за грешка
        if(!isValidUsername){
            lblWrongUsername.setText("Username should contains at least 2 letters - upper or lower case.");
        }
        if(!isValidPhone){
            lblWrongPhone.setText("Phone should contains two groups of digits surrounded by parenthesis.");
        }
        if(!isValidEmail){
            lblWrongEmail.setText("Email should contains only lowercase letters, no duplicate @, dots and spaces inside.");
        }
        if(!isValidPassword){
            lblWrongPassword.setText("Password should be at least 5 symbols, one lower and upper case, digit and symbol.");
        }
        if(!isValidConfirmPassword){
            lblWrongConfPassword.setText("Confirm password should be identical to password.");
        }

        return isValidUsername && isValidPhone && isValidEmail && isValidPassword && isValidConfirmPassword;
    }

    private void messageBox(String title, String contentText){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contentText);
        alert.showAndWait();
    }

}
