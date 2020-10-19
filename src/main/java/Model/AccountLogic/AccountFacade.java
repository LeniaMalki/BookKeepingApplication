package Model.AccountLogic;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.AccountSubject;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a facade which delegates work to AccountExistenceManager and AccountEditor in order to create, delete and
 * change the variables of an account.
 * @author Lenia
 */
public class AccountFacade implements AccountSubject {
    private final AccountEditor accountEditor = AccountEditor.getInstance();

    private static AccountFacade accountFacade;
    private final List<AccountObserver> UserObservers = new ArrayList<>();
    private final AccountExistenceManager accountExistenceManager = AccountExistenceManager.getInstance();
    private final AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();
    private final SendMail sendMail=new SendMail();

    /**
     * Private constructor
     */
    private AccountFacade() {
    }

    //---------------------------------------------------- GETTERS -----------------------------------------------------

    /**
     * Method for obtaining the account facade instance.
     */
    public static AccountFacade getInstance() {
        if (accountFacade == null) {
            accountFacade = new AccountFacade();
        }
        return accountFacade;
    }

    /**
     * Getter
     */
    public String getAccountName() {
        return accountEditor.getAccountName();
    }

    /**
     * Gets account username through delegation to accountEditor
     * @return returns account username
     */
    public String getAccountUsername() {
        return accountEditor.getAccountUsername();

    }

    /**
     * Gets account password through delegation to accountEditor
     * @return returns account password
     */
    private String getaccountPassword() {
        return accountEditor.getAccountPassword();
    }

    /**
     * Gets account email through delegation to accountEditor
     * @return returns account email
     */
    public String getAccountEmail() {
        return accountEditor.getAccountEmail();

    }

    //---------------------------------------------------- METHODS -----------------------------------------------------

    /**
     * Sets account password through delegation to accountEditor
     * @param password is passed in by the controller in use of the method
     */
    public void updateAccountPassword(String password) {
        accountEditor.setAccountPassword(password);
    }
    /**
     * sends an email to the user with their password
     */
    public void sendPasswordToEmail() {
        sendMail.sendEmail(getAccountEmail(),getaccountPassword(),"ForgetPassword");
    }
    /**
     * Delegates the creation of an account to the account existence manager
     * @param signUpName is passed in by the getText() method of corresponding textField in controller signUp
     * @param signUpUsername is passed in by the getText() method of corresponding textField in controller signUp
     * @param signUpPassword is passed in by the getText() method of corresponding textField in controller signUp
     * @param signUpConfirmPassword is passed in by the getText() method of corresponding textField in controller
     * signUp
     * @param signUpEmail is passed in by the getText() method of corresponding textField in controller signUp
     * @return returns a created account
     */
    public boolean createAccount(String signUpName, String signUpUsername,
                                 String signUpPassword, String signUpConfirmPassword, String signUpEmail) {
        return accountExistenceManager.createAccount(signUpName, signUpUsername,
                                                     signUpPassword, signUpConfirmPassword, signUpEmail);
    }

    /**
     * Delegates the deletion of an account to the account existence manager
     */
    public void deleteAccount() {
        accountExistenceManager.deleteAccount();
    }

    /**
     * Works as a last check before setting new account values.
     * @param username obtained from controllers textField
     * @param name obtained from controllers textField
     * @param email obtained from controllers textField
     * @return returns a corresponding int depending on the matching case
     */
    public int handleAccountChanges(String username, String name, String email) {

        int changes = countProfilePageChanges(username, name, email);

        //Returns 0 if no changes made
        if (changes == 0) {
            return 0;
        } else if (changes > 0 && accountValidityChecker.areAllProfilePageValuesCorrect(username, name, email)) {
            return 1;
        } else return 3;

    }

    /**
     * Counts/checks if any changes has been made to the textFields of the profile page
     * @param username obtained from ProfilePageController
     * @param name obtained from ProfilePageController
     * @param email obtained from ProfilePageController
     * @return returns the number of changes made to profile page, empty values are not considered as a change
     */
    private int countProfilePageChanges(String username, String name, String email) {
        ArrayList<String> newInputs = new ArrayList<>() {
            {
                add(username);
                add(name);
                add(email);
            }
        };
        ArrayList<String> oldInputs = new ArrayList<>() {{
            add(getAccountUsername());
            add(getAccountName());
            add(getAccountEmail());

        }};

        int changes = 3;

        for (int i = 0; i <= oldInputs.size() - 1; i++) {

            if (newInputs.get(i).equals("")) {
                return 3;
            } else if (newInputs.get(i).equals(oldInputs.get(i))) {
                changes--;
            }
        }
        return changes;
    }

    /**
     * Assigns values to the account page textFields
     * @param username obtained from textField on account page
     * @param name obtained from textField on account page
     * @param email obtained from textField on account page
     */
    public void updateAccountFields(String username, String name, String email) {
        accountEditor.setAccountUsername(username);
        accountEditor.setAccountName(name);
        accountEditor.setAccountEmail(email);
    }

    /**
     * Check whether the the input password matches that of the account in order to delete the account
     * @param password is passed in  through accountFacade though deleteAccountPopup textField
     */
    public boolean doesPasswordMatchWithAccount(String password) {
        return password.equals(accountEditor.getAccountPassword());
    }

    /**
     * Checks whether input password is valid through delegation to accountValidityChecker
     * @param password obtained from textField
     * @return true if true returned from accountValidityChecker
     */
    public boolean isValidPasswordFormat(String password) {
        return accountValidityChecker.isValidPasswordLength(password);
    }
    //---------------------------------------------------- Observer Pattern --------------------------------------------

    /**
     * Adds observers to its litst of UserObservers
     */
    @Override
    public void add(AccountObserver o) {
        UserObservers.add(o);
    }

    /**
     * Notifies all of its observers in its oserverlist to update
     */
    @Override
    public void notifyListeners() {
        for (AccountObserver observer : UserObservers) {
            observer.update();
        }

    }
}
