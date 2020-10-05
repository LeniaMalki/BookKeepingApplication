package Model;

import Model.Interfaces.EntryObserver;

import java.util.ArrayList;

public abstract class EntrySubject {
    public ArrayList<EntryObserver> observers = new ArrayList<>();

    //methods to register observers

    public void add(EntryObserver o) {
        observers.add(o);
    }

    public void notifyListeners() {
    }

}