package Model.EntryLogic;

import Interfaces.iEntry;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.EntrySubject;

/**
 * A class creates entries that are imputed by the user
 *
 * @author Artin
 */

public class Entry  implements iEntry, EntrySubject {
    private final double amount;
   private final String name;
  private final String category;
  private final String typeOfEntry;



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
    }

    /**
     * Notifies all the observers of the object
     */
    public void notifyEntryListeners() {
        for (final EntryObserver observer : observers) {
            observer.update(this);
            observer.update(getCategory(), getTypeOfEntry(), getAmount());
        }
    }

    //--------------------------------------- Getter/Setter---------------------------------------
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