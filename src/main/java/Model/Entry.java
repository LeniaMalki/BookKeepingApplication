package Model;

import Model.Interfaces.EntrySubjects;
import Model.Interfaces.EntryObserver;

import java.util.ArrayList;
import java.util.List;


public class Entry extends EntrySubject implements EntrySubjects {
    private List<EntryObserver> observers = new ArrayList<>();
    //private T message;

    double amount;
    String name;
    String category;
    String typeOfEntry;


    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amount = cost;
        this.name = name;
        this.category = category;
        this.typeOfEntry = typeOfEntry;
    }

    @Override
    public void addEntryListener(EntryObserver o ) {
        observers.add(o);
    }

    @Override
    public void notifyEntryListeners() {
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

    @Override
    public void notifyListeners() {
        for (EntryObserver observer : observers) {
            observer.update(this.getCategory(), this.getTypeOfEntry(), amount);
        }
    }
}