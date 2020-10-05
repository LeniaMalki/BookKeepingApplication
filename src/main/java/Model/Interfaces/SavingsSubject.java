package Model.Interfaces;

import java.util.ArrayList;

public interface SavingsSubject {
        ArrayList<SavingsObserver> observers = new ArrayList<>();
        public void add(SavingsObserver o);
        public void notifyListeners (String s);



    }


