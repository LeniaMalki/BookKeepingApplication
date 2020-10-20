package Model.Interfaces;

import Model.EntryLogic.iEntry;

public interface EntryObserver {

    //method to update the observer, used by subject
    void update(String category, String type, double Value);
    void update(iEntry entry);

}