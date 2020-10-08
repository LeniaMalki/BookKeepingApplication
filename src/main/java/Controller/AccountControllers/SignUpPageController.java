package Controller.AccountControllers;

import Controller.MainControllers.MainController;
import Model.AccountLogic.AccountFacade;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SignUpPageController {

    //________________________________________________ VARIABLES _______________________________________________________

    private final AccountFacade accountFacade = AccountFacade.getInstance();
    MainController parent;

    //________________________________________________ FXML ____________________________________________________________
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

    public void initPane(MainController parent) {
        this.parent = parent;

    }

    @FXML
    private void handleCreateAccountAction() {
        if (!(accountFacade.createAccount(signUpName, signUpUsername, signUpPassword, signUpConfirmPassword,
                signUpEmail) == null)) {
            accountFacade.notifyListeners();
            clearTextFields();
        } else fieldsMissingText.setFill(Color.RED);
    }

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


