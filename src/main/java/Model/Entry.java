package Model;

import Model.Interfaces.EntryObserver;

/**
 * A class creates entries that are imputed by the user
 *
 * @author Artin
 */

public class Entry extends EntrySubject {
    double amount;
    String name;
    String category;
    String typeOfEntry;
    boolean selected;



    /**
     * Constructor that initializes a new entry object
     * @param cost the amount of money that the entry is about
     * @param name name of the entrie
     * @param category the category that the entry falls under
     * @param typeOfEntry the type of entry the object is, income, expense or savings
     */
    public Entry(double cost, String name, String category, String typeOfEntry) {
        this.amount = cost;
        this.name = name;
        this.category = category;
        this.typeOfEntry = typeOfEntry;
        this.selected = false;
    }

    /**
     * Notifies all the observers of the object
     */
    public void notifyEntryListeners() {
        for (EntryObserver observer : observers) {
            observer.update(this);
            observer.update(getCategory(), getTypeOfEntry(), getAmount());
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

    public boolean getSelected(){
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

}