package Model;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.AccountSubject;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.EntrySubject;

import java.util.ArrayList;
import java.util.List;

public class User implements AccountSubject, AccountObserver, EntrySubject {


    private static EntryHandler entryHandler;
    private static User userInstance;
    private final List<AccountObserver> UserObservers = new ArrayList<AccountObserver>();
    private final List<EntryObserver> EntryObservers = new ArrayList<EntryObserver>();
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
            entryHandler = new EntryHandler();
        }
        return userInstance;
    }

    public static boolean userExists() {

        return getInstance() != null;
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

    public EntryHandler getEntryHandler() {
        return entryHandler;
    }

    public boolean doesUserExist() {
        return this.getName() != null;
    }

    @Override
    public void add(AccountObserver o) {
        UserObservers.add(o);

    }

    @Override
    public void add(EntryObserver o) {
        EntryObservers.add(o);
    }

    public void notifyEntryListeners() {
        for (EntryObserver observer : EntryObservers) {
            observer.update();
        }

    }

    @Override
    public void notifyListeners() {
        for (AccountObserver observer : UserObservers) {
            observer.update();
        }

    }

// _____________________________________ Acting as an observer ______________________________________


    @Override
    public void update() {


    }
}
