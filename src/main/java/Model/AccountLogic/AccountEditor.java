package Model.AccountLogic;

/**
 * Handles all edits on the account, makes use of an accountInstance and is thus an instance itself
 * @author Lenia
 */
public class AccountEditor {
    private static AccountEditor accountEditor;


    //________________________________________________ Variables _______________________________________________________

    private final Account account = Account.getInstance();
    private final AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();

    //________________________________________________ Methods _________________________________________________________

    /**
     * Private constructor
     */
    private AccountEditor() {
    }

    /**
     * Method for obtaining the account editor instance.
     */
    static AccountEditor getInstance() {
        if (accountEditor == null) {
            accountEditor = new AccountEditor();
        }
        return accountEditor;

    }

    /**
     * Sets all account values to the given parameters
     * @param name obtained from controller's textField.
     * @param username obtained from controller's textField.
     * @param password obtained from controller's textField.
     * @param email obtained from controller's textField.
     */
    void setAllAccountValues(String name, String username,
                             String password, String email) {

        account.setName(name);
        account.setUsername(username);
        account.setEmailAddress(email);
        account.setPassword(password);
    }

    /**
     * Sets all account's variables to null
     */
    void nullAllAccountValues() {
        account.setName(null);
        account.setUsername(null);
        account.setEmailAddress(null);
        account.setPassword(null);
    }

    //________________________________________________ Getters/setters _________________________________________________
    /**
     * Getter
     * @return returns the value of the account instance's name
     */
    String getAccountName() {
        return account.getName();
    }

    /**
     * Sets a new account name for the account iff the password is valid though check by accountValidityChecker
     * @param textField is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountName(String textField) {
        if (accountValidityChecker.isValidName(textField)) {
            account.setName(textField);
        }
    }

    /**
     * Getter
     * @return returns the value of the account instance's username
     */
    String getAccountUsername() {
        return account.getUsername();
    }

    /**
     * Sets a new account username for the account iff the password is valid though check by accountValidityChecker
     * @param username is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountUsername(String username) {
        if (accountValidityChecker.isValidUsername(username)) {
            account.setUsername(username);
        }
    }

    /**
     * Getter
     * @return returns the value of the account instance's email
     */
    String getAccountEmail() {
        return account.getEmailAddress();
    }

    /**
     * Sets a new account email for the account iff the password is valid though check by accountValidityChecker
     * @param email is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountEmail(String email) {
        if (accountValidityChecker.isValidEmail(email)) {
            account.setEmailAddress(email);


        } //else textField.setStyle("-fx-text-box-border: #B22222;");

    }

    /**
     * Getter
     * @return returns the value of the account instance's password
     */
    String getAccountPassword() {
        return account.getPassword();
    }

    /**
     * Sets a new password for the account iff the password is valid though check by accountValidityChecker
     * @param password is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountPassword(String password) {
        if (accountValidityChecker.isValidPasswordLength(password)) {
            account.setPassword(password);
        } //else textField.setStyle("-fx-text-box-border: #B22222;");
    }
}
