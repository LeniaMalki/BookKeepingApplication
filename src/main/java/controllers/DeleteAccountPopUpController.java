package controllers;

import Model.AccountDataHandler;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class DeleteAccountPopUpController {

    @FXML
    public AnchorPane delAccPopUp;
    MainController parent;
    @FXML
    private PasswordField enterPasswordToDelete;
    @FXML
    private Text passwordIncorrectMessage;

    //Initialize
    public void initPane(MainController parent) {
        this.parent = parent;
    }

    //Button actions
    @FXML
    private void deleteAccountConfirm() {

        AccountDataHandler accountDataHandler = new AccountDataHandler() {
            @Override
            public boolean doesPasswordMatch(String inputPassword) {
                return super.doesPasswordMatch(inputPassword);
            }

            @Override
            public void deleteAccount() {
                super.deleteAccount();
            }
        };

        if (accountDataHandler.doesPasswordMatch(enterPasswordToDelete.getText())) {
            accountDataHandler.deleteAccount();
            parent.showLogInPage();
        } else {
            passwordIncorrectMessage.setText("Password is incorrect! Try again.");
        }


    }

}