package Model.EntryLogic;

import StairwayInterfaces.iEntry;
import StairwayInterfaces.iEntryHandler;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.EntrySubject;

import java.util.ArrayList;
import java.util.List;


/**
 * A class that handles the entries in our program
 *
 * @author Oscar
 */

public final class EntryHandler implements EntryObserver, iEntryHandler {

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


    public static EntryHandler getInstance() {
        if (entryHandler == null) {
            synchronized (EntryHandler.class){
                if(entryHandler == null){
                    entryHandler = new EntryHandler();
                }
            }
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
    public void removeEntry(iEntry entry) {
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
            if ("Food".equals(entry.getCategory())) {
                foodAmount += entry.getAmount();
            }
            if ("Transportation".equals(entry.getCategory())) {
                transportationAmount += entry.getAmount();
            }
            if ("Household".equals(entry.getCategory())) {
                householdAmount += entry.getAmount();
            }
            if ("Shopping".equals(entry.getCategory())) {
                shoppingAmount += entry.getAmount();
            }
            if ("Other".equals(entry.getCategory())) {
                otherAmount += entry.getAmount();
            }
            if ("General Saving".equals(entry.getCategory())) {
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
