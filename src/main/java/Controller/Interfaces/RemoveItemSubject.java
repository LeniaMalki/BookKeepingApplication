package Controller.Interfaces;

public interface RemoveItemSubject {
    void add(RemoveItemObserver o);

    void notifyListeners();
}
