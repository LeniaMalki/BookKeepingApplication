package Model.Interfaces;

public interface EntrySubjects {
    //methods to register observers

    public void addEntryListener(EntryObserver o);
    public void notifyEntryListeners();

}