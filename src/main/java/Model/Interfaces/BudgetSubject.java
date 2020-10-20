package Model.Interfaces;

import Model.Interfaces.BudgetObserver;

import java.util.ArrayList;

public interface BudgetSubject {

     ArrayList<BudgetObserver> observers = new ArrayList<>();

    //methods to register observers

    /**
     * adds observers to a class that extends this
     *
     * @param o the observer that subscribes as a listener
     */
     static void add(BudgetObserver o) {
        observers.add(o);
    }

    /**
     * Notifies all the observers that subscribe to an object that a change has happened
     */
    void notifyBudgetListeners();


}

