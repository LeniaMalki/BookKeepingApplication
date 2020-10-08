package Model.EntryLogic;

import Model.Interfaces.EntryObserver;

import java.util.ArrayList;

/**
 * The observer abstract subject class
 *
 * @author Artin
 */
public abstract class EntrySubject {
    public static ArrayList<EntryObserver> observers = new ArrayList<>();

    //methods to register observers

    /**
     * adds observers to a class that extends this
     * @param o the observer that subscribes as a listener
     */
    public static void add(EntryObserver o) {
        observers.add(o);
    }

    /**
     * Notifies all the observers that subscribe to an object that a change has happened
     */
    public abstract void notifyEntryListeners();


}