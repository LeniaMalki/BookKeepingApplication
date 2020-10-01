package controllers;

import Model.AccountDataHandler;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class SignUpPageController {

    public AnchorPane signUpPopUp;
    MainController parent;

    User user = User.getInstance();

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

    public void initPane(MainController parent) {
        this.parent = parent;
    }

    @FXML
    private void handleCreateAccountAction() {

        AccountDataHandler accountDataHandler = new AccountDataHandler() {
            @Override
            public User createUser(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                   TextField signUpPassword, TextField signUpConfirmPassword) {
                return super.createUser(signUpName, signUpUsername, signUpEmail, signUpPassword, signUpConfirmPassword);
            }

            @Override
            public boolean isAllFieldsEntered(TextField signUpName, TextField signUpUsername, TextField signUpEmail,
                                              TextField signUpPassword, TextField signUpConfirmPassword) {
                return super.isAllFieldsEntered(signUpName, signUpUsername, signUpEmail, signUpPassword,
                                                signUpConfirmPassword);
            }
        };

        if (accountDataHandler.isAllFieldsEntered(signUpName, signUpUsername, signUpEmail, signUpPassword,
                                                  signUpConfirmPassword)) {
            fieldsMissingText.setFill(Color.WHITE);

            if (accountDataHandler.createUser(signUpName, signUpUsername, signUpEmail, signUpPassword,
                                              signUpConfirmPassword) != null) {
                user.notifyListeners();
                clearTextFields();
            }
        } else fieldsMissingText.setFill(Color.RED);

    }

    //TODO
    @FXML
    private void handleOnExitClicked () {
    }


    private void clearTextFields() {

        signUpName.clear();
        signUpName.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpEmail.clear();
        signUpEmail.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpPassword.clear();
        signUpPassword.setStyle("-fx-text-box-border: #FFFFFF;");

        signUpConfirmPassword.clear();
        signUpConfirmPassword.setStyle("-fx-text-box-border: #FFFFFF;");
    }


}


