package Model.Interfaces;

public interface EntrySubject {
    //methods to register observers

     void register(EntryObserver obj);

    //method to notify observers of change
     void notifyObservers();

    //method to get updates from subject
    public Object getUpdate(EntryObserver obj);
}
