package Model.Interfaces;

import Controller.Interfaces.AccountObserver;

public interface AccountSubject {

    public void add(AccountObserver o);
    public void notifyListeners ();



}
