package Model;


import Model.observers.UserObserver;

import java.util.ArrayList;
import java.util.List;

public class MainModel {
    User user;
    private final List<UserObserver> observers = new ArrayList<>();
    private int state;

    //Adds a new observer to the list
    public void add(UserObserver o) {
        observers.add(o);
    }

    public int getState() {
        return state;
    }

    public void setState(int value) {
        this.state = value;
        notifyAllObservers();
    }

    private void notifyAllObservers() {
        for (UserObserver observer : observers) {
            observer.notifed();
        }
    }

    public String getUserName() {
        return user.getName();
    }

    public void setUsername(String username) {
        user.setUsername(username);
        notifyAllObservers();
    }



}
