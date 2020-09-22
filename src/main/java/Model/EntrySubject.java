package Model;

public interface EntrySubject {
    //methods to register observers

     void register(NewEntryObserver obj);

    //method to notify observers of change
     void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(NewEntryObserver obj);
}
