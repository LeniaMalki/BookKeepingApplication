package Model.AccountLogic;

import javafx.scene.control.TextField;

public class AccountEditor {
    //________________________________________________ Variables _______________________________________________________
    private static AccountEditor accountEditor;

    private final Account account = Account.getInstance();

    private final  AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();

    //________________________________________________ Methods _________________________________________________________

    public static AccountEditor getInstance() {
        if (accountEditor == null) {
            accountEditor = new AccountEditor();
        }
        return accountEditor;

    }

    void setAccountName(TextField textField) {
        if (accountValidityChecker.isValidName(textField.getText())) {
            account.setName(textField.getText());
        } else textField.setStyle("-fx-text-box-border: #B22222;");
    }

    void setAccountEmail(TextField textField) {
        if (accountValidityChecker.isValidEmail(textField.getText())) {
            account.setEmailAddress(textField.getText());
        } else textField.setStyle("-fx-text-box-border: #B22222;");

    }

    void setAccountUsername(TextField textField) {
        if (textField.getText() != null) {
            account.setUsername(textField.getText());
        } else textField.setStyle("-fx-text-box-border: #B22222;");
    }

     boolean setAccountPassword(TextField textField) {
        if (accountValidityChecker.checkPasswordLength(textField.getText())) {
            account.setPassword(textField.getText());
            return true;
        } else textField.setStyle("-fx-text-box-border: #B22222;");
        return false;
    }

    boolean areAccountFieldsCorrect(TextField username, TextField name, TextField email) {

        boolean areFieldsCorrect = true;

        //Username
        if (username.getText().equals("")) {
            username.setStyle("-fx-text-box-border: #B22222;"); //RED
            areFieldsCorrect = false;
        }
        else username.setStyle("-fx-text-box-border: #008000;");

        //Name
        if (!accountValidityChecker.isValidName(name.getText())) {
            name.setStyle("-fx-text-box-border: #B22222;"); //RED
            areFieldsCorrect = false;
        }
        else name.setStyle("-fx-text-box-border: #008000;");

        //Email
        if (!accountValidityChecker.isValidEmail(email.getText())) {
            email.setStyle("-fx-text-box-border: #B22222;"); //RED
            areFieldsCorrect = false;
        }
        else email.setStyle("-fx-text-box-border: #008000;");


        return areFieldsCorrect;
    }


    String getAccountName() {
        return account.getName();
    }
    String getAccountUsername() {
        return account.getUsername();
    }
    String getAccountEmail() {
        return account.getEmailAddress();
    }
    String getAccountPassword() {
        return account.getPassword();
    }
}
