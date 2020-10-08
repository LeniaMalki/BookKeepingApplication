package Model.Interfaces;

import Model.EntryLogic.Entry;

public interface EntryObserver {

    //method to update the observer, used by subject
    void update(String category, String type, double Value);
    void update(Entry entry);

}