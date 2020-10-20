package Interfaces;

public interface iEntry {
    double getAmount();

    String getName();

    String getCategory();

    String getTypeOfEntry();

    Model.EntryLogic.iEntry getEntry();

    void notifyEntryListeners();

}
