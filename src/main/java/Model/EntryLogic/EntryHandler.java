package Model.EntryLogic;

import Interfaces.iEntry;
import Interfaces.iEntryHandler;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.EntrySubject;

import java.util.ArrayList;
import java.util.List;


/**
 * A class that handles the entries in our program
 *
 * @author Oscar
 */

public class EntryHandler implements EntryObserver, iEntryHandler {

    //________________________________________________ VARIABLES _______________________________________________________

    private static EntryHandler entryHandler;
    private static double foodAmount;
    private static double transportationAmount;
    private static double householdAmount;
    private  static double shoppingAmount;
    private  static double otherAmount;
    private  static double generalSaving;
    private final List<iEntry> entries = new ArrayList<>();

    //_________________________________________________ METHODS ________________________________________________________

    /**
     * private constructor so that there will only be one object that oversees all the entries
     */
    private EntryHandler() {
        EntrySubject.add(this);
    }

    synchronized public static EntryHandler getInstance() {
        if (entryHandler == null) {
            entryHandler = new EntryHandler();
        }
        return entryHandler;
    }

    /**
     * A function that adds our entry to a list of entries
     *
     * @param entry , an entry with a specific category
     */
    public void addEntry(iEntry entry) {
        entries.add(entry);
    }

    /**
     * A function that removes our entry to a list of entries
     *
     * @param entry , an entry with a specific category
     */
    public void removeEntry(Entry entry) {
        entries.remove(entry);
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
        generalSaving = 0;
        for (final iEntry entry : entries) {
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
            if (entry.getCategory().equals("General Saving")) {
                generalSaving += entry.getAmount();
            }
        }
    }

    @Override
    public void update(String category, String type, double Value) {

    }

    @Override
    public void update(iEntry entry) {
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

    public double getGeneralSaving() {
        return generalSaving;
    }

    public List<iEntry> getEntries() {
        return entries;
    }

}
