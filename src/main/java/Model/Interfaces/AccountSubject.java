package Model.Interfaces;

public interface AccountSubject {

    public void add(AccountObserver o);
    public void notifyListeners ();



}
