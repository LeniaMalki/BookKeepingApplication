package Model.AccountLogic;

/**
 * Class which manages the creation and deletion of an account
 *
 * @author Lenia
 */
public class AccountExistenceManager {

    private static final AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();
    //________________________________________________ Variables _______________________________________________________
    private static AccountExistenceManager accountExistenceManager;
    private final Account account = Account.getInstance();


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
     * @param name            is passed in by the accountFacade though whichever controller is in need of the
     *                        method
     * @param username        is passed in by the accountFacade though whichever controller is in need of the
     *                        method
     * @param password        is passed in by the accountFacade though whichever controller is in need of the
     *                        method
     * @param confirmPassword is passed in by the accountFacade though whichever controller is in need of the
     *                        method
     * @param email           is passed in by the accountFacade though whichever controller is in need of the
     *                        method
     */
    Account createAccount(String name, String username,
                          String password, String confirmPassword, String email) {

        if (signUpFieldsChecker(name, username,
                                password, confirmPassword, email) == 0) {

            assignUserFields(name, username,
                             password, confirmPassword, email);
            return account;
        }

        return null;
    }

    /**
     * Sets the variables of the account instance. Used in method createAccount if all fields are valid
     *
     * @param name            is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param username        is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param password        is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param confirmPassword is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param email           is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     */
    private void assignUserFields(String name, String username,
                                  String password, String confirmPassword, String email) {
        account.setName(name);
        account.setUsername(username);
        account.setEmailAddress(email);
        account.setPassword(password);
        account.setConfirmPassword(confirmPassword);
    }

    /**
     * Check whether the inputs for the account variables are valid by delegation t accountValidityChecker
     *
     * @param name            is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param username        is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param password        is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param confirmPassword is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     * @param email           is passed in by the createAccount method through accountFacade though signUpPage
     *                        textfields
     */
    private int signUpFieldsChecker(String name, String username,
                                    String password, String confirmPassword, String email) {

        int i = 0;

        if (!accountValidityChecker.isValidName(name)) {
            System.out.println("Invalid name");
            //signUpName.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        }
        //else signUpName.setStyle("-fx-text-box-border: #008000;");
        if (!accountValidityChecker.isValidEmail(email)) {
            System.out.println("Invalid email");

            //signUpEmail.setStyle("-fx-text-box-border: #FF0000;");
            //textFields.set(1, "false");
            i++;
        }
        //else signUpEmail.setStyle("-fx-text-box-border: #008000;");
        if (username.equals("")) {
            System.out.println("Invalid username");

            // signUpUsername.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        }
        //else signUpUsername.setStyle("-fx-text-box-border: #008000;");

        if (!accountValidityChecker.checkPasswordLength(password)) {
            System.out.println("Invalid password");

            //signUpPassword.setStyle("-fx-text-box-border: #FF0000;");
            i++;
        }
        //else signUpPassword.setStyle("-fx-text-box-border: #008000;");

        if (!accountValidityChecker.checkSignupPasswordMatch(password,
                                                             confirmPassword)) {
            System.out.println("Invalid password match");

            //signUpConfirmPassword.setStyle("-fx-text-box-border: #B22222;");
            i++;
        }
        //else signUpConfirmPassword.setStyle("-fx-text-box-border: #008000;");
        System.out.println("All fields valid");

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


