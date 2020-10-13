package Model.BudgetLogic;

import Model.Interfaces.BudgetObserver;
import Model.Interfaces.EntryObserver;

import java.util.ArrayList;

public abstract class BudgetSubject {

        public static ArrayList<BudgetObserver> observers = new ArrayList<>();

        //methods to register observers

        /**
         * adds observers to a class that extends this
         * @param o the observer that subscribes as a listener
         */
        public static void add(BudgetObserver o) {
            observers.add(o);
        }

        /**
         * Notifies all the observers that subscribe to an object that a change has happened
         */
        public abstract void notifyBudgetListeners();


    }

