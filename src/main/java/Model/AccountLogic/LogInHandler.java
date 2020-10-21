package Model.AccountLogic;//NOPMD


import StairwayInterfaces.iAccountFacade;
/**
 * A class that handles the logic of login in to logIn page
 * @author Lenia
 */
public abstract class LogInHandler {//NOPMD

    //________________________________________________ Variables _______________________________________________________
    private final iAccountFacade accountFacade = AccountFacade.getInstance();

    //---------------------------------------------------- METHODS -----------------------------------------------------
    /**
     * checks whether the usernames matches
     * @param accountName is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginAccountName(final String accountName) {
        return accountFacade.getAccountUsername().equals(accountName);
    }

    /**
     * checks whether the password matches
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginPassword(final String password) {
        return accountFacade.doesPasswordMatchWithAccount(password);
    }

    /**
     * handles the actual login
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    public boolean logIn(final String accountName,final String password) {

        boolean isLogInCorrect = true;
        if (!checkLoginAccountName(accountName)) {
            isLogInCorrect = false;
        }
        if (!checkLoginPassword(password)) {
            isLogInCorrect = false;
        }
        return isLogInCorrect;
    }
}
