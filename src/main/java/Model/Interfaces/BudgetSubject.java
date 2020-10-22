package Model.Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface BudgetSubject {

    List<BudgetObserver> observers = new ArrayList<>();

    //methods to register observers

    /**
     * adds observers to a class that extends this
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

