package View.AccountView;//NOPMD

import Controller.MainControllers.MainController;
import View.Interfaces.iPane;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * @author : Lenia Malki
 * Responsibility: In charge of displaying the pop up for changing account password.
 * Used by: PasswordEditController
 * Uses: iPane, JavaFX, MainController
 */
public class ChangePasswordView implements iPane {
    //________________________________________________ Variables _______________________________________________________
    private static ChangePasswordView changePasswordView;//NOPMD
    @FXML
    public PasswordField newPassword;
    @FXML
    public PasswordField confirmPassword;
    @FXML
    public Text textMessage;
    @FXML
    public Button confirmChangeButton;//NOPMD
    MainController parent;//NOPMD//NOPMD

    //________________________________________________ Methods _________________________________________________________
    /**
     * Constructor
     */
    public ChangePasswordView() {
        changePasswordView = this;
    }

    /**
     * Singleton pattern for getting an view of change password pop up
     * @return instance of view
     */
    public static ChangePasswordView getInstance() {
        if (changePasswordView == null) {
            synchronized (ChangePasswordView.class) {
                changePasswordView = new ChangePasswordView();
            }
        }
        return changePasswordView;
    }

    /**
     * Sets error message on view
     * @param message gets sent in by controller
     */
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

    /**
     * Initializes pane
     * @param parent mainController
     */
    @Override
    public void initPane(final MainController parent) {
        this.parent = parent;
    }
}


