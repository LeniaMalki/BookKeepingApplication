package Model.GoalsLogic;

import Interfaces.iEntry;
import Interfaces.iSavingGoal;
import Interfaces.iSavingsOverview;
import Model.Interfaces.EntrySubject;
import Model.Interfaces.EntryObserver;
import Model.Interfaces.SavingsObserver;
import Model.Interfaces.SavingsSubject;
import Model.Interfaces.iSavingsRegister;

import java.util.HashMap;

/**
 * A class that has a overview of all the savings
 *
 * @author Artin
 */
public class SavingsOverview implements iSavingsRegister, SavingsSubject, EntryObserver, iSavingsOverview {
    HashMap<String, iSavingGoal> savingGoalHashMap = new HashMap<>();
    private static SavingsOverview savingsInstance;

    /**
     * private constructor so that there will only be one object that oversees all the savings
     */
    private SavingsOverview() {
        EntrySubject.add(this);
    }

    synchronized public static SavingsOverview getInstance() {
        if (savingsInstance == null) {
            savingsInstance = new SavingsOverview();
        }
        return savingsInstance;
    }

    /**
     * Adds money to a specific goal.
     *
     * @param category the category that the saving is, basically the name of the saving
     * @param cost     the amout of money that one wants to add to the saving
     */
    public void addToSaving(String category, double cost) {
        savingGoalHashMap.get(category).addMoneyToSaving(cost);
    }


    /**
     * Adds a new saving goal
     *
     * @param name name of the new saving goal
     * @param goal the amount that is needed to reach the goal
     */
    @Override
    public void addSavingsGoal(String name, iSavingGoal goal) {
        savingGoalHashMap.put(name, goal);
        notifyListeners(name);
    }

    /**
     * adds a object as a listener to this class, so that when something happens they will be notified
     *
     * @param o
     */
    @Override
    public void add(SavingsObserver o) {
        observers.add(o);
    }

    /**
     * Notifies all observers about a change
     *
     * @param name name a parameter that being sent to an observer
     */
    @Override
    public void notifyListeners(String name) {
        for (SavingsObserver o : observers) {
            o.update(name);
        }
    }

    /**
     * updates the SavingsOverview that some change has happened somewhere else
     *
     * @param category category of the change
     * @param type     type of the change
     * @param money    the amount of money the change is about
     */
    @Override
    public void update(String category, String type, double money) {
        if (type.equals("Savings")) {
            addToSaving(category, money);
        }
    }

    @Override
    public void update(iEntry entry) {
// TODO have to make it only one update
    }


    public double getAmountSaved(String name) {
        return savingGoalHashMap.get(name).getSavingGoalReached();
    }
}
