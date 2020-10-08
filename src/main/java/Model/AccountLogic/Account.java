package Model.AccountLogic;

/**
 * The concept of an account; designed through singleton pattern.
 *
 * @author Lenia
 */
public class Account {

    //________________________________________________ Variables  ______________________________________________________
    private static Account accountInstance;

    private String name;
    private String username;
    private String emailAddress;
    private String password;
    private String confirmPassword;


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

    /**
     * Setter
     */
    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     * Getter
     */
    public String getName() {
        return name;
    }

    /**
     * Setter
     */
    public void setName(String name) {
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
    public void setUsername(String username) {
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
    public void setEmailAddress(String emailAddress) {
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
    public void setPassword(String password) {
        this.password = password;
    }

}
