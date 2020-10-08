package Model;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.AccountSubject;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class AccountFacade implements AccountSubject {
    private static AccountFacade accountFacade;

    private final List<AccountObserver> UserObservers = new ArrayList<>();

    AccountExistenceManager accountExistenceManager = AccountExistenceManager.getInstance();
    AccountEditor accountEditor = AccountEditor.getInstance();

    public boolean checkPasswordValidity (TextField password) {
        return accountEditor.setAccountPassword(password);
    }


    private AccountFacade() {
    }

    public static AccountFacade getInstance() {
        if (accountFacade == null) {
            accountFacade = new AccountFacade();
        }
        return accountFacade;
    }

    public String getAccountName() {
        return accountEditor.getAccountName();

    }

    public String getAccountUsername() {
        return accountEditor.getAccountUsername();

    }

    public String getAccountEmail() {
        return accountEditor.getAccountEmail();

    }

    public void setAccountName (TextField name) {
        accountEditor.setAccountName(name);
    }
    public void setAccountUsername (TextField username) {
        accountEditor.setAccountUsername(username);
    }
    public boolean setAccountPassword (TextField  password) {
        return accountEditor.setAccountPassword(password);
    }

    public void setAccountEmail (TextField email) {
        accountEditor.setAccountEmail(email);
    }

    public Account createAccount(TextField signUpName, TextField signUpUsername,
                                 TextField signUpPassword, TextField signUpConfirmPassword, TextField signUpEmail) {
        return accountExistenceManager.createAccount(signUpName, signUpUsername,
                signUpPassword, signUpConfirmPassword, signUpEmail);
    }

    public void deleteAccount() {
        accountExistenceManager.deleteAccount();
    }

    @Override
    public void add(AccountObserver o) {
        UserObservers.add(o);

    }

    @Override
    public void notifyListeners() {
        for (AccountObserver observer : UserObservers) {
            observer.update();
        }

    }

    public String getAccountPassword () {
       return accountEditor.getAccountPassword();
    }

    public boolean isAccountPageFieldsCorrect(TextField username, TextField name, TextField email) {
        return accountEditor.areAccountFieldsCorrect(username, name, email);
    }

    public boolean checkPasswordMatch(String inputPassword) {
        return accountExistenceManager.checkPasswordMatch(inputPassword);

    }

}
