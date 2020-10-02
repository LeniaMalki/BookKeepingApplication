package Model;

import Model.Interfaces.EntryObserver;

import java.util.ArrayList;
import java.util.List;


public class Entry extends EntrySubject {
    private List<EntryObserver> observers = new ArrayList<>();

    double amout;
    String name;
    String category;
    String typeOfEntry;


    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amout = cost;
        this.name = name;
        this.category = category;
        this.typeOfEntry = typeOfEntry;
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

    public Entry getEntry() {
        return this;    
    }

}