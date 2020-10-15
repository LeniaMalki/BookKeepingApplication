package Model.AccountLogic;


/**
 * A class that handles the logic of login in to logIn page
 * @author Lenia
 */
public abstract class LogInHandler {
    private final AccountFacade accountFacade = AccountFacade.getInstance();

    /**
     * checks whether the usernames matches
     * @param accountName is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginAccountName(String accountName) {
        return accountFacade.getAccountUsername().equals(accountName);
    }

    /**
     * checks whether the password matches
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    private boolean checkLoginPassword(String password) {
         return accountFacade.doesPasswordMatchWithAccount(password);
    }

    /**
     * handles the actual login
     * @param password is the variables obtained from logInTextField on logIn controller
     */
    public boolean logIn(String accountName, String password) {

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
