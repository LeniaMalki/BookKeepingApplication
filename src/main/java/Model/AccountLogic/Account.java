package Model.AccountLogic;//NOPMD

/**
 * The concept of an account; designed through singleton pattern.
 *
 * @author Lenia
 */
public final class Account {

    //________________________________________________ Variables  ______________________________________________________
    private static Account accountInstance;

    private String name;
    private String username;
    private String emailAddress;
    private String password;
    //________________________________________________ Methods _________________________________________________________

    /**
     * Private constructor
     */
    private Account() {
    }

    /**
     * Method for obtaining the account instance. Handles the creation of a new account object.
     */
    public static Account getInstance() {
        if (accountInstance == null) {
            accountInstance = new Account();
        }
        return accountInstance;
    }

    //________________________________________________ Getters/Setters _________________________________________________

    /**
     * Getter
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Getter
     */
    public String getUsername() {
        return username;
    }

    /**
     * Setter
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Getter
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Setter
     */
    public void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Getter
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter
     */
    public void setPassword(final String password) {
        this.password = password;
    }

}
