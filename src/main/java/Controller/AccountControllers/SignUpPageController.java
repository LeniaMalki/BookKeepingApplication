package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.util.ArrayList;

/**
 * Controller for signUp pop up through logInPage
 * @author Lenia
 */

public class SignUpPageController {

    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    MainController parent;
    ArrayList<TextField> textFields = new ArrayList<>() {};
    @FXML
    private TextField signUpName;
    @FXML
    private TextField signUpUsername;
    @FXML
    private PasswordField signUpPassword;
    @FXML
    private PasswordField signUpConfirmPassword;
    @FXML
    private TextField signUpEmail;
    //________________________________________________ Methods _________________________________________________________
    @FXML
    private Text textMessage;

    /**
     * initialized this pane
     */
    public void initPane(MainController parent) {
        this.parent = parent;
        textFields.add(signUpName);
        textFields.add(signUpUsername);
        textFields.add(signUpPassword);
        textFields.add(signUpConfirmPassword);
        textFields.add(signUpEmail);
    }

    /**
     * Handles the mouse action of creating an account. The logic of creating and checking valid inputs is implemented
     * through the AccountFacade
     */
    @FXML
    private void onCreateAccountClicked() {
        if (areInputsMissing()) {
            textMessage.setText("Missing inputs!");

        } else if ((accountFacade.createAccount((signUpName.getText()), signUpUsername.getText(),
                                                signUpPassword.getText(), signUpConfirmPassword.getText(),
                                                signUpEmail.getText()))) {
            accountFacade.notifyListeners();
            clearTextFields();
            textMessage.setText("");
        } else textMessage.setText("Invalid input(s)!");
    }

    /**
     * Checks whether all fields of the sign up page are entered and none is left blank
     */
    private boolean areInputsMissing() {
        ArrayList<String> textFieldStrings = new ArrayList<>() {
            {
                add(signUpName.getText());
                add(signUpUsername.getText());
                add(signUpEmail.getText());
                add(signUpPassword.getText());
                add(signUpConfirmPassword.getText());
            }
        };


        for (String textFieldInput : textFieldStrings) {
            if (textFieldInput.equals("")) {
                return true;
            }
        }
        return false;
    }

    /**
     * Resets all border colors and texts of the sign up page text fields.
     */
    private void clearTextFields() {

        for (TextField t : textFields) {
            t.clear();
            t.setStyle("-fx-text-box-border: #FFFFFF;");
        }
    }
}


