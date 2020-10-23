package Model.Interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * The observer abstract subject class
 * @author Artin
 */
public interface EntrySubject {
    List<EntryObserver> observers = new ArrayList<>();

    //methods to register observers

    /**
     * adds observers to a class that extends this
     * @param observer the observer that subscribes as a listener
     */
    static void add(EntryObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifies all the observers that subscribe to an object that a change has happened
     */
    void notifyEntryListeners();


}