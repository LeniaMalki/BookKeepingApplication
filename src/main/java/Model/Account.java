package Model;


public class Account  {

    //________________________________________________ Variables  ______________________________________________________
    private static Account accountInstance;

    private String name;
    private String username;
    private String emailAddress;
    private String password;
    private String confirmPassword;

    //________________________________________________ Getters/Setters  ________________________________________________
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    //________________________________________________ Methods _________________________________________________________
    private Account() { }

    public boolean doesUserExist() {
        return this.getName() != null;
    }

    public static Account getInstance() {
        if (accountInstance == null) {
            accountInstance = new Account();
        }
        return accountInstance; }




}
