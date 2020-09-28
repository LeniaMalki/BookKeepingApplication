package Model.Interfaces;

public interface EntrySubject {
    //methods to register observers

    public void add(EntryObserver o);
    public void notifyListeners ();

}