package Model.Interfaces;

import Model.EntrySubject;

public interface EntryObserver {

    //method to update the observer, used by subject
    void update(EntrySubject e);


}