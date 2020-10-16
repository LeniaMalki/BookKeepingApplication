package View.AccountView;

import Controller.Interfaces.iPane;
import Controller.MainControllers.MainController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class SignUpView implements iPane {

    public static SignUpView signUpView;

    MainController parent;
    ArrayList<TextField> textFields = new ArrayList<>() {};
    @FXML
    public TextField signUpName;
    @FXML
    public TextField signUpUsername;
    @FXML
    public PasswordField signUpPassword;
    @FXML
    public PasswordField signUpConfirmPassword;
    @FXML
    public TextField signUpEmail;
    @FXML
    public Text textMessage;
    @FXML
    public Button createAccount;

    public SignUpView() {
        signUpView = this;
    }

    public static SignUpView getInstance() {
        if (signUpView == null) {
            signUpView = new SignUpView();
        }
        return signUpView;
    }

    @Override
    public void initPane(MainController parent) {
        this.parent = parent;

        textFields.add(signUpName);
        textFields.add(signUpUsername);
        textFields.add(signUpPassword);
        textFields.add(signUpConfirmPassword);
        textFields.add(signUpEmail);

    }

    public void setMessage(String message) {
        textMessage.setText(message);

    }

    /**
     * Resets all border colors and texts of the sign up page text fields.
     */
    public void clearTextFields() {

        for (TextField t : textFields) {
            t.clear();
            t.setStyle("-fx-text-box-border: #FFFFFF;");
        }
    }

}
