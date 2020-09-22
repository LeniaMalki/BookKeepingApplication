package Model.observers;

import Model.AccountMaker;

public interface EntrySubject {
    //methods to register observers

     void register(AccountMaker.NewEntryObserver obj);

    //method to notify observers of change
     void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(AccountMaker.NewEntryObserver obj);
}
