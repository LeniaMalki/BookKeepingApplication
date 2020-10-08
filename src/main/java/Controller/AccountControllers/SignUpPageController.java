package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

/**
 * Controller for signUp pop up through logInPage
 *
 * @author Lenia
 */

public class SignUpPageController {

    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    MainController parent;

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
    @FXML
    private Text fieldsMissingText;

    //________________________________________________ Methods _________________________________________________________

    /**
     * initialized this pane
     */
    public void initPane(MainController parent) {
        this.parent = parent;

    }

    /**
     * Handles the mouse action of creating an account. The logic of creating and checking valid inputs is implemented
     * through the AccountFacade
     */
    @FXML
    private void handleCreateAccountAction() {
        if (!isAllFieldsEntered()) {
            fieldsMissingText.setFill(Color.RED);
        } else if (!(accountFacade.createAccount(signUpName, signUpUsername, signUpPassword, signUpConfirmPassword,
                                                 signUpEmail) == null)) {
            accountFacade.notifyListeners();

            clearTextFields();
        } else fieldsMissingText.setFill(Color.WHITE);

    }

    /**
     * Checks whether all fields of the sign up page are entered and none is left blank
     */
    private boolean isAllFieldsEntered() {
        return (!signUpName.getText().equals("") && !signUpUsername.getText().equals("") && !signUpEmail.getText().equals("") && !signUpPassword.getText().equals("") && !signUpConfirmPassword.getText().equals(""));
    }

    /**
     * Resets all border colors and texts of the sign up page text fields.
     */
    private void clearTextFields() {

        signUpName.clear();
        signUpName.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpUsername.clear();
        signUpUsername.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpEmail.clear();
        signUpEmail.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpPassword.clear();
        signUpPassword.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpConfirmPassword.clear();
        signUpConfirmPassword.setStyle("-fx-text-box-border: #FFFFFF;");
    }


}


