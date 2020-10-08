package Model.AccountLogic;

import javafx.scene.control.TextField;

public class AccountExistenceManager {

    //________________________________________________ Variables _______________________________________________________
    private static AccountExistenceManager accountExistenceManager;

    private final Account account = Account.getInstance();

    private final AccountValidityChecker accountValidityChecker = new AccountValidityChecker();

    //________________________________________________ Methods _________________________________________________________

    public static AccountExistenceManager getInstance() {
        if (accountExistenceManager == null) {
            accountExistenceManager = new AccountExistenceManager();
        }
        return accountExistenceManager;
    }

    Account createAccount(TextField signUpName, TextField signUpUsername,
                          TextField signUpPassword, TextField signUpConfirmPassword, TextField signUpEmail) {

            if (signUpFieldsChecker(signUpName, signUpUsername,
                    signUpPassword, signUpConfirmPassword, signUpEmail) == 0) {

                assignUserFields(signUpName, signUpUsername,
                        signUpPassword, signUpConfirmPassword, signUpEmail);
                return account;
            }

        return null;
    }

    private void assignUserFields(TextField signUpName, TextField signUpUsername,
                                  TextField signUpPassword, TextField signUpConfirmPassword, TextField signUpEmail) {
        account.setName(signUpName.getText());
        account.setUsername(signUpUsername.getText());
        account.setEmailAddress(signUpEmail.getText());
        account.setPassword(signUpPassword.getText());
        account.setConfirmPassword(signUpConfirmPassword.getText());

    }

    private int signUpFieldsChecker(TextField signUpName, TextField signUpUsername,
                                    TextField signUpPassword, TextField signUpConfirmPassword, TextField signUpEmail) {

        int i = 0;

        if (!accountValidityChecker.isValidName(signUpName.getText())) {
            signUpName.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        } else signUpName.setStyle("-fx-text-box-border: #008000;");

        if (!accountValidityChecker.isValidEmail(signUpEmail.getText())) {
            signUpEmail.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        } else signUpEmail.setStyle("-fx-text-box-border: #008000;");

        if (signUpUsername.getText().equals("")) {
            signUpUsername.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        } else signUpUsername.setStyle("-fx-text-box-border: #008000;");

        if (!accountValidityChecker.checkPasswordLength(signUpPassword.getText())) {
            signUpPassword.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        } else signUpPassword.setStyle("-fx-text-box-border: #008000;");

        if (!accountValidityChecker.checkSignupPasswordMatch(signUpPassword.getText(),
                signUpConfirmPassword.getText())) {
            signUpConfirmPassword.setStyle("-fx-text-box-border: #B22222;");
            i++;
        } else signUpConfirmPassword.setStyle("-fx-text-box-border: #008000;");
        return i;
    }



    void deleteAccount() {
        account.setName(null);
        account.setName(null);
        account.setUsername(null);
        account.setEmailAddress(null);
        account.setPassword(null);
        account.setConfirmPassword(null);
    }

    boolean checkPasswordMatch(String inputPassword) {
        return inputPassword.equals(account.getPassword());

    }


}


