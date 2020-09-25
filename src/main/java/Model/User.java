package Model;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.AccountSubject;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.UserObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class User implements AccountSubject {

    private final List<AccountObserver> UserObservers = new ArrayList<AccountObserver>();


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
}
