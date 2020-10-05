package Model;

import Model.Interfaces.EntrySubject;
import Model.Interfaces.EntryObserver;

import java.util.ArrayList;
import java.util.List;


public class Entry<T> implements EntrySubject {
    private List<EntryObserver> observers = new ArrayList<>();
    private T message;

    double amount;
    String name;
    String category;
    String typeOfEntry;


    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amount = cost;
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


    public double getAmount() {
        return amount;
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

    public Entry getEntry() {
        return this;
    }

}