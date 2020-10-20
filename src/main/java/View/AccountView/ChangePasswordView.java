package View.AccountView;//NOPMD

import View.Interfaces.iPane;
import Controller.MainControllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * @author : Lenia Malki
 * Responsibility: In charge of displaying the pop up for changing account password.
 * Used by: PasswordEditController
 * Uses: iPane interface, JavaFX, MainController
 */
public class ChangePasswordView implements iPane {

    public static ChangePasswordView changePasswordView;//NOPMD
    @FXML
    public PasswordField newPassword;
    @FXML
    public PasswordField confirmPassword;
    @FXML
    public Text textMessage;
    @FXML
    public Button confirmChangeButton;//NOPMD
    MainController parent;//NOPMD//NOPMD

    public ChangePasswordView() {
        changePasswordView = this;
    }

    public static ChangePasswordView getInstance() {
        if (changePasswordView == null) {
            changePasswordView = new ChangePasswordView();
        }
        return changePasswordView;
    }


    public void setMessage(final String message) {

        if ("invalid".equals(message)) {
            textMessage.setText("Invalid new password.");
        }
        if ("correct".equals(message)) {
            textMessage.setText("Changes saved!");

        }
        if ("noMatch".equals(message)) {
            textMessage.setText("Password does not match.");

        }

    }


    @Override
    public void initPane(final MainController parent) {
        this.parent = parent;
    }
}


