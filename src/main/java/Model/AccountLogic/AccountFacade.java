package Model.AccountLogic;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.AccountSubject;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a facade which delegates work to AccountExistenceManager and AccountEditor in order to create, delete
 * and change the variables of an account.
 *
 * @author Lenia
 */
public class AccountFacade implements AccountSubject {
    private static AccountFacade accountFacade;
    AccountExistenceManager accountExistenceManager = AccountExistenceManager.getInstance();
    AccountEditor accountEditor = AccountEditor.getInstance();
    private final List<AccountObserver> UserObservers = new ArrayList<>();

    /**
     * Private constructor
     */
    private AccountFacade() {
    }

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
     * Sets account name through delegation to accountEditor
     *
     * @param name is passed in by the controller in use of the method
     */
    public void setAccountName(String name) {
        accountEditor.setAccountName(name);
    }

    /**
     * Gets account username through delegation to accountEditor
     *
     * @return returns account username
     */
    public String getAccountUsername() {
        return accountEditor.getAccountUsername();

    }

    /**
     * Sets account usernamename through delegation to accountEditor
     *
     * @param username is passed in by the controller in use of the method
     */
    public void setAccountUsername(String username) {
        accountEditor.setAccountUsername(username);
    }

    /**
     * Gets account email through delegation to accountEditor
     *
     * @return returns account email
     */
    public String getAccountEmail() {
        return accountEditor.getAccountEmail();

    }

    /**
     * Sets account email through delegation to accountEditor
     *
     * @param email is passed in by the controller in use of the method
     */
    public void setAccountEmail(String email) {
        accountEditor.setAccountEmail(email);
    }

    /**
     * Sets account password through delegation to accountEditor
     *
     * @param password is passed in by the controller in use of the method
     * @return returns a boolean value if the username is valid
     */
    public boolean setAccountPassword(String password) {
        return accountEditor.setAccountPassword(password);
    }

    public boolean checkPassword (String password) {
        return accountExistenceManager.checkPassword(password);
    }

    /**
     * Delegates the creation of an account to the account existence manager
     *
     * @param signUpName            is passed in by the getText() method of corresponding textField in controller signUp
     * @param signUpUsername        is passed in by the getText() method of corresponding textField in controller signUp
     * @param signUpPassword        is passed in by the getText() method of corresponding textField in controller signUp
     * @param signUpConfirmPassword is passed in by the getText() method of corresponding textField in controller
     *                              signUp
     * @param signUpEmail           is passed in by the getText() method of corresponding textField in controller signUp
     * @return returns a created account
     */
    public Account createAccount(String signUpName, String signUpUsername,
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

    /**
     * Delegates the check for the changing of accont page's fields to accountEditor
     */
    public boolean isAccountPageFieldsCorrect(String username, String name, String email) {
        return accountEditor.areAccountFieldsCorrect(username, name, email);
    }

    /**
     * Delegates the check for password match to accountExistanceManager
     */
    public boolean checkPasswordMatch(String inputPassword) {
        return accountExistenceManager.checkPasswordMatch(inputPassword);

    }

}
