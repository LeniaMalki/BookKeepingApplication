package Model.AccountLogic;//NOPMD

/**
 * Class which manages the creation and deletion of an account
 *
 * @author Lenia
 */
public final class AccountExistenceManager {


    //________________________________________________ Variables _______________________________________________________
    private static AccountExistenceManager accountExistenceManager;//NOPMD
    //private final Account account = Account.getInstance();
    private final AccountEditor accountEditor = AccountEditor.getInstance();//NOPMD
    private static final AccountValidityChecker accountValidityChecker = AccountValidityChecker.getInstance();//NOPMD

    //________________________________________________ Methods _________________________________________________________

    /**
     * Private constructor
     */
    private AccountExistenceManager() {
    }

    /**
     * Method for obtaining/creating a accountExistenceManager object
     */
    static AccountExistenceManager getInstance() {//NOPMD
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
    boolean createAccount(final String name, final String username,final  String password,final  String confirmPassword, final String email) {//NOPMD

        if (accountValidityChecker.areAllAccountValuesCorrect(name, username, password, confirmPassword, email)) {

            accountEditor.setAllAccountValues
                    (name, username,
                     password, email);
            return true;//NOPMD
        }
        else {return false;}
    }

    /**
     * Deletes the account by setting all the accounts' variables to null
     */
    void deleteAccount() {//NOPMD
        accountEditor.nullAllAccountValues();
    }

}


