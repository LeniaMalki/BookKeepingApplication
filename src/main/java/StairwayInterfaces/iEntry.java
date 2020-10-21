package StairwayInterfaces;

import Model.EntryLogic.Entry;

public interface iEntry {
    double getAmount();

    String getName();

    String getCategory();

    String getTypeOfEntry();

    Entry getEntry();

    void notifyEntryListeners();

}
