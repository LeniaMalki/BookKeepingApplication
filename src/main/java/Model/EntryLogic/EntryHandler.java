package Model.EntryLogic;

import StairwayInterfaces.iEntry;
import StairwayInterfaces.iEntryHandler;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.EntrySubject;

import java.util.ArrayList;
import java.util.List;
/**
 * @author : Oscar Forsberg
 * Responsibility: A class for handling all the entries in our program.
 * Used by: BudgetChartPageController, HomePageController, StatisticsDetailController, StatisticsOverviewController
 * Uses: iEntry, EntryObserver, iEntryHandler
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
     * Constructor
     */
    private EntryHandler() {
        EntrySubject.add(this);
    }

    /**
     * Singleton pattern for getting an instance of this class
     * @return instance of view
     */
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
    public void addEntry(final iEntry entry) {
        entries.add(entry);
    }

    /**
     * A function that removes our entry to a list of entries
     *
     * @param entry , an entry with a specific category
     */
    public void removeEntry(final iEntry entry) {
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
        for ( final iEntry entry : entries) {
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

<<<<<<< Updated upstream
    @Override
    public void update(final String category, final String type, final double Value) {

    }
    /**
     * Method for updating when an entry is added
     */
=======

>>>>>>> Stashed changes
    @Override
    public void update(final iEntry entry) {
        addEntry(entry);
    }

    //____________________________________________ GETTERS / SETTERS ___________________________________________________
    /**
     * Getter
     * @return sum of values of entries with category "Food"
     */
    public double getFoodAmount() {
        return foodAmount;
    }
    /**
     * Getter
     * @return sum of values of entries with category "Transportation"
     */
    public double getTransportationAmount() {
        return transportationAmount;
    }
    /**
     * Getter
     * @return sum of values of entries with category "Household"
     */
    public double getHouseholdAmount() {
        return householdAmount;
    }
    /**
     * Getter
     * @return sum of values of entries with category "Shopping"
     */
    public double getShoppingAmount() {
        return shoppingAmount;
    }
    /**
     * Getter
     * @return sum of values of entries with category "Other"
     */
    public double getOtherAmount() {
        return otherAmount;
    }
    /**
     * Getter
     * @return sum of values of entries with category "General Saving"
     */
    public double getGeneralSaving() {
        return generalSaving;
    }
    /**
     * Getter
     * @return list of entries
     */
    public List<iEntry> getEntries() {
        return entries;
    }

}
