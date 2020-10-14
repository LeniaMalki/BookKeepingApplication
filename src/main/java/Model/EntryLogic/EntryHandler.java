package Model.EntryLogic;

import Model.Interfaces.EntryObserver;

import java.util.ArrayList;
import java.util.List;


/**
 * A class that handles the entries in our program
 *
 * @author Oscar
 */

public class EntryHandler implements EntryObserver {

    //________________________________________________ VARIABLES _______________________________________________________

    private static EntryHandler entryHandler;
    static double foodAmount;
    static double transportationAmount;
    static double householdAmount;
    static double shoppingAmount;
    static double otherAmount;
    private final List<Entry> entries = new ArrayList<>();

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * private constructor so that there will only be one object that oversees all the entries
     */
    private EntryHandler() {
        EntrySubject.add(this);
    }

    public static EntryHandler getInstance() {
        if (entryHandler == null) {
            entryHandler = new EntryHandler();
        }
        return entryHandler;
    }

    /**
     * A function that adds our entry to a list of entries
     *
     * @param e , an entry with a specific category
     */
    public void addEntry(Entry e) {
        entries.add(e);
    }

    /**
     * A function that removes our entry to a list of entries
     *
     * @param e , an entry with a specific category
     */
    public void removeEntry(Entry e) {
        entries.remove(e);
    }

    /**
     * A function that sets all values to 0 and then iterates through the
     * list of entries and adds their values up in different categories
     */
    public void updateTotalCategoryValues() {
        foodAmount = 0;
        transportationAmount = 0;
        householdAmount = 0;
        shoppingAmount = 0;
        otherAmount = 0;
        for (Entry entry : entries) {
            if (entry.getCategory().equals("Food")) {
                foodAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Transportation")) {
                transportationAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Household")) {
                householdAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Shopping")) {
                shoppingAmount += entry.getAmount();
            }
            if (entry.getCategory().equals("Other")) {
                otherAmount += entry.getAmount();
            }
        }
    }

    @Override
    public void update(String category, String type, double Value) {

    }

    @Override
    public void update(Entry entry) {
        addEntry(entry);
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________

    public double getFoodAmount() {
        return foodAmount;
    }

    public double getTransportationAmount() {
        return transportationAmount;
    }

    public double getHouseholdAmount() {
        return householdAmount;
    }

    public double getShoppingAmount() {
        return shoppingAmount;
    }

    public double getOtherAmount() {
        return otherAmount;
    }

    public List<Entry> getEntries() {
        return entries;
    }
}
