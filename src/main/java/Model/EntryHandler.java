package Model;

import java.util.ArrayList;
import java.util.List;

public class EntryHandler {
    private final List<Entry> entries = new ArrayList<>();

    public  double getFoodAmount() {
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

    static double foodAmount;
    static double transportationAmount;
    static double householdAmount;
    static double shoppingAmount;
    static double otherAmount;

    public List<Entry> getEntries() {
        return entries;
    }

    public void addEntry(Entry e) {
        entries.add(e);
    }

    public void update(){
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
}
