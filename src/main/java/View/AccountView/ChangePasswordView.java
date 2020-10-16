package View.AccountView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;


public class ChangePasswordView implements iPane {

    public static ChangePasswordView changePasswordView;
    @FXML
    public PasswordField newPassword;
    @FXML
    public PasswordField confirmPassword;
    @FXML
    public Text textMessage;
    @FXML
    public Button confirmChangeButton;
    MainController parent;

    public ChangePasswordView() {
        changePasswordView = this;
    }

    public static ChangePasswordView getInstance() {
        if (changePasswordView == null) {
            changePasswordView = new ChangePasswordView();
        }
        return changePasswordView;
    }


    public void setMessage(String message) {

        if (message.equals("invalid")) {
            textMessage.setText("Invalid new password.");
        }
        if (message.equals("correct")) {
            textMessage.setText("Changes saved!");

        }
        if (message.equals("noMatch")) {
            textMessage.setText("Password does not match.");

        }

    }


    @Override
    public void initPane(MainController parent) {
        this.parent = parent;
    }
}


