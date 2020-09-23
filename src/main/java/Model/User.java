package Model;

public class User {

    private static User userInstance;

    private String name;
    private String username;
    private String emailAddress;
    private String password;
    private String confirmPassword;

    private User() {

    }

    public static User getInstance() {
        if (userInstance == null) {
            userInstance = new User();
        }
        return userInstance;
    }

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

    //_________________________________________________________________________________________________________________

    public boolean isAllFieldsEntered() {

        return (name != null && username != null && emailAddress != null && password != null && confirmPassword != null);
    }

    public boolean doesPasswordMatch(String confirmPassword) {
        return this.password.equals(confirmPassword);
    }

}
