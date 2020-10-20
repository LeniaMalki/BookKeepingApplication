package Model.Interfaces;

import Interfaces.iEntry;

public interface EntryObserver {

    //method to update the observer, used by subject
    void update(String category, String type, double Value);
    void update(iEntry entry);

}