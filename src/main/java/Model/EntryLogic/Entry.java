package Model.EntryLogic;

import Model.Interfaces.EntryObserver;
import Model.Interfaces.EntrySubject;
import StairwayInterfaces.iEntry;

/**
 * A class creates entries with the information that is inputted by the client
 * Responsibility: create entries and inform others that it is created
 * Used by: EntryHandler, indirectly though iEntry
 *
 * @author Artin
 */
public class Entry  implements iEntry, EntrySubject {
    private final double amount;
   private final String name;
  private final String category;
  private final String typeOfEntry;


    //________________________________________________ Methods _________________________________________________________

    /**
     * Constructor that initializes a new entry object
     * @param cost the amount of money that the entry is about
     * @param name name of the entrie
     * @param category the category that the entry falls under
     * @param typeOfEntry the type of entry the object is, income, expense or savings
     */
    public Entry(final double cost, final String name, final String category,final  String typeOfEntry) {
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

    //--------------------------------------- Getter---------------------------------------
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