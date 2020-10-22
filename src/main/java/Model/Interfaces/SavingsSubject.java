package Model.Interfaces;

import java.util.ArrayList;
import java.util.List;

public interface SavingsSubject {
        List<SavingsObserver> observers = new ArrayList<>();
        public void add(SavingsObserver o);
        public void notifyListeners (String s);



    }


