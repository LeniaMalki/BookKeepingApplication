package Model.AccountLogic;

import javafx.scene.control.TextField;

/**
 * Class which manages the creation and deletion of an account
 *
 * @author Lenia
 */
public class AccountExistenceManager {

    //________________________________________________ Variables _______________________________________________________
    private static  AccountExistenceManager accountExistenceManager;

    private final Account account = Account.getInstance();

    private static final AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();

    //________________________________________________ Methods _________________________________________________________

    /**
     * Private constructor
     */
    private AccountExistenceManager() {
    }

    /**
     * Method for obtaining/creating a accountExistenceManager object
     */
    public static AccountExistenceManager getInstance() {
        if (accountExistenceManager == null) {
            accountExistenceManager = new AccountExistenceManager();
        }
        return accountExistenceManager;
    }

    /**
     * Handles the creation of an account
     *
     * @param signUpName            is passed in by the accountFacade though whichever controller is in need of the
     *                              method
     * @param signUpUsername        is passed in by the accountFacade though whichever controller is in need of the
     *                              method
     * @param signUpPassword        is passed in by the accountFacade though whichever controller is in need of the
     *                              method
     * @param signUpConfirmPassword is passed in by the accountFacade though whichever controller is in need of the
     *                              method
     * @param signUpEmail           is passed in by the accountFacade though whichever controller is in need of the
     *                              method
     */
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

    /**
     * Sets the variables of the account instance. Used in method createAccount if all fields are valid
     *
     * @param signUpName            is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpUsername        is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpPassword        is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpConfirmPassword is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpEmail           is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     */
    private void assignUserFields(TextField signUpName, TextField signUpUsername,
                                  TextField signUpPassword, TextField signUpConfirmPassword, TextField signUpEmail) {
        account.setName(signUpName.getText());
        account.setUsername(signUpUsername.getText());
        account.setEmailAddress(signUpEmail.getText());
        account.setPassword(signUpPassword.getText());
        account.setConfirmPassword(signUpConfirmPassword.getText());

    }

    /**
     * Check whether the inputs for the account variables are valid by delegation t accountValidityChecker
     *
     * @param signUpName            is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpUsername        is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpPassword        is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpConfirmPassword is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     * @param signUpEmail           is passed in by the createAccount method through accountFacade though signUpPage
     *                              textfields
     */
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

    /**
     * Deletes the account by setting all the accounts' variables to null
     */
    void deleteAccount() {
        account.setName(null);
        account.setName(null);
        account.setUsername(null);
        account.setEmailAddress(null);
        account.setPassword(null);
        account.setConfirmPassword(null);
    }

    /**
     * Check whether the the input password matches that of the account in order to delete the account
     *
     * @param inputPassword is passed in  through accountFacade though deleteAccountPopup textField
     */
    boolean checkPasswordMatch(String inputPassword) {
        return inputPassword.equals(account.getPassword());

    }


}


