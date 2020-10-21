package Controller.Interfaces;

import java.util.ArrayList;

public interface RemoveItemSubject {
    static void add(RemoveItemObserver o){
        observers.add(o);
    }
    ArrayList<RemoveItemObserver> observers = new ArrayList<>();

    void notifyListeners();
}
