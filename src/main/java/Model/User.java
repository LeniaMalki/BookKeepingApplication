package Model;

public class User {

    private String name;
    private String language;
    private String username;
    private char emailAddress;
    private char password;

    public User(String name, String  username, char emailAddress, char password) {
        this.name = name;
        this.username = username;
        this.emailAddress = emailAddress;
        this.password = password;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public char getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(char emailAddress) {
        this.emailAddress = emailAddress;
    }

    public char getPassword() {
        return password;
    }

    public void setPassword(char password) {
        this.password = password;
    }
}
