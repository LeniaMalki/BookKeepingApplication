package Model;

import Model.Interfaces.AccountObserver;
import Model.Interfaces.EntrySubject;
import Model.Interfaces.EntryObserver;

import java.util.ArrayList;
import java.util.List;


public class Entry<T> implements EntrySubject {
    private List<EntryObserver> observers = new ArrayList<>();
    private T message;

    double amout;
    String name;
    String category;
    String typeOfEntry;


    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amout = cost;
        this.name = name;
        this.category=category;
        this.typeOfEntry=typeOfEntry;
    }

    @Override
    public void add (EntryObserver o ) {
        observers.add(o);
    }

    @Override
    public void notifyListeners () {
        for ( EntryObserver observer : observers ) {
            observer.update ();
        }
    }


    public double getAmout() {
        return amout;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getTypeOfEntry() {
        return typeOfEntry;
    }

}