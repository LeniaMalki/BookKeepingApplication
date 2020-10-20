package Interfaces;

import Model.Interfaces.AccountSubject;

public interface iAccountFacade extends AccountSubject {
    boolean createAccount(final String signUpName, final String signUpUsername,
                          final String signUpPassword, final String signUpConfirmPassword,//NOPMD
                          final String signUpEmail);

    String getAccountName();

    String getAccountUsername();

    String getAccountEmail();

    void updateAccountFields(final String username, final String name, final String email);

    int handleAccountChanges(final String username, final String name, final String email);

    void sendPasswordToEmail();

    boolean doesPasswordMatchWithAccount(final String password);

    void deleteAccount();

    boolean isValidPasswordFormat(final String password);

    void updateAccountPassword(final String password);
}
