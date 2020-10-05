package Model;

import Model.Interfaces.EntryObserver;

import java.util.ArrayList;

public abstract class EntrySubject {
    public static ArrayList<EntryObserver> observers = new ArrayList<>();

    //methods to register observers

    public static void add(EntryObserver o) {
        observers.add(o);
    }

    public abstract void notifyListeners();
    }