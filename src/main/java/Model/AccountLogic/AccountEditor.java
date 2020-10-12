package Model.AccountLogic;

/**
 * Handles all edits on the account, makes use of an accountInstance and is thus an instance itself
 *
 * @author Lenia
 */
public class AccountEditor {
    //________________________________________________ Variables _______________________________________________________
    private static AccountEditor accountEditor;

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
     * Sets a new password for the account iff the password is valid though check by accountValidityChecker
     *
     * @param password is passed in by the accountFacade though whichever controller is in need of the method
     */
    boolean setAccountPassword(String password) {
        if (accountValidityChecker.checkPasswordLength(password)) {
            account.setPassword(password);
            return true;
        } //else textField.setStyle("-fx-text-box-border: #B22222;");
        return false;
    }

    /**
     * Check whether all account page fields are valid though check by accountValidityChecker
     *
     * @param username is passed in by the accountFacade though whichever controller is in need of the method
     * @param name     is passed in by the accountFacade though whichever controller is in need of the method
     * @param email    is passed in by the accountFacade though whichever controller is in need of the method
     */
    boolean areAccountFieldsCorrect(String username, String name, String email) {

        boolean areFieldsCorrect = true;

        //Username
        if (username.equals("")) {
            //username.setStyle("-fx-text-box-border: #B22222;"); //RED
            System.out.println("Incorrect username");
            areFieldsCorrect = false;
        } //else username.setStyle("-fx-text-box-border: #008000;"); //Green

        //Name
        if (!accountValidityChecker.isValidName(name)) {
            //name.setStyle("-fx-text-box-border: #B22222;"); //RED

            System.out.println("Incorrect name");

            areFieldsCorrect = false;
        } //else name.setStyle("-fx-text-box-border: #008000;");

        //Email
        if (!accountValidityChecker.isValidEmail(email)) {
            System.out.println("Incorrect email");

            //email.setStyle("-fx-text-box-border: #B22222;"); //RED
            areFieldsCorrect = false;
        } //else email.setStyle("-fx-text-box-border: #008000;");


        return areFieldsCorrect;
    }

    /**
     * Getter
     *
     * @return returns the value of the account instance's name
     */
    String getAccountName() {
        return account.getName();
    }

    /**
     * Sets a new account name for the account iff the password is valid though check by accountValidityChecker
     *
     * @param textField is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountName(String textField) {
        if (accountValidityChecker.isValidName(textField)) {
            account.setName(textField);
        }   //else textField.setStyle("-fx-text-box-border: #B22222;");
    }

    /**
     * Getter
     *
     * @return returns the value of the account instance's username
     */
    String getAccountUsername() {
        return account.getUsername();
    }

    /**
     * Sets a new account username for the account iff the password is valid though check by accountValidityChecker
     *
     * @param username is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountUsername(String username) {
        if (accountValidityChecker.checkUsername(username)) {
            account.setUsername(username);
        } //else textField.setStyle("-fx-text-box-border: #B22222;");
    }

    /**
     * Getter
     *
     * @return returns the value of the account instance's email
     */
    String getAccountEmail() {
        return account.getEmailAddress();
    }

    /**
     * Sets a new account email for the account iff the password is valid though check by accountValidityChecker
     *
     * @param email is passed in by the accountFacade though whichever controller is in need of the method
     */
    void setAccountEmail(String email) {
        if (accountValidityChecker.isValidEmail(email)) {
            account.setEmailAddress(email);
        } //else textField.setStyle("-fx-text-box-border: #B22222;");

    }

    /**
     * Getter
     *
     * @return returns the value of the account instance's password
     */
    String getAccountPassword() {
        return account.getPassword();
    }
}
