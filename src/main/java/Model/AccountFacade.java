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


    private AccountFacade() {
        this.accountExistenceManager = accountExistenceManager;
        this.accountEditor = accountEditor;
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

    //Methods
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

    public boolean isAccountPageFieldsCorrect(TextField name, TextField email, TextField username) {
        return accountEditor.isAccountPageFieldsCorrect(name, email, username);
    }

    public boolean checkPasswordMatch(String inputPassword) {
        return accountExistenceManager.checkPasswordMatch(inputPassword);

    }

}
