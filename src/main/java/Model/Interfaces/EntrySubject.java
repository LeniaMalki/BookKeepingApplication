package Model.Interfaces;

import Model.Interfaces.EntryObserver;

import java.util.ArrayList;

/**
 * The observer abstract subject class
 *
 * @author Artin
 */
public interface EntrySubject {
     ArrayList<EntryObserver> observers = new ArrayList<>();

    //methods to register observers

    /**
     * adds observers to a class that extends this
     *
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