package Controller.Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface RemoveItemSubject {
    List<RemoveItemObserver> observers = new ArrayList<>();

    static void add(RemoveItemObserver o) {
        observers.add(o);
    }

    void notifyListeners();
}
