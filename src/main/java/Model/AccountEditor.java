package Model;

import javafx.scene.control.TextField;

public class AccountEditor {
    //________________________________________________ Variables _______________________________________________________
    private static AccountEditor accountEditor;

    Account account = Account.getInstance();

    AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();

    //________________________________________________ Methods _________________________________________________________

    public static AccountEditor getInstance() {
        if (accountEditor == null) {
            accountEditor = new AccountEditor();
        }
        return accountEditor;

    }

    boolean setAccountName(TextField textField) {
        if (accountValidityChecker.isValidName(textField.getText())) {
            account.setName(textField.getText());
            return true;
        } else textField.setStyle("-fx-text-box-border: #B22222;");
        return false;
    }

    String getAccountName() {return account.getName();}

    boolean setAccountEmail(TextField textField) {
        if (accountValidityChecker.isValidEmail(textField.getText())) {
            account.setEmailAddress(textField.getText());
            return true;
        } else textField.setStyle("-fx-text-box-border: #B22222;");
        return false;

    }

    boolean setAccountUsername(TextField textField) {
        if (textField.getText() != null) {
            account.setUsername(textField.getText());
            return true;
        } else textField.setStyle("-fx-text-box-border: #B22222;");
        return false;
    }

    boolean setAccountPassword(TextField textField) {
        if (accountValidityChecker.checkPasswordLength(textField.getText())) {
            account.setPassword(textField.getText());
            return true;
        } else textField.setStyle("-fx-text-box-border: #B22222;");
        return false;
    }

    boolean isAccountPageFieldsCorrect(TextField name, TextField email, TextField username) {
        return (accountValidityChecker.isValidName(name.toString()) && accountValidityChecker.isValidEmail(email.toString()) && !username.getText().equals(""));

    }

    public String getAccountUsername() {
        return account.getUsername();
    }

    public String getAccountEmail() {
        return account.getEmailAddress();
    }
}
