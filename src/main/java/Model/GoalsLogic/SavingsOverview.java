package Model.GoalsLogic;

import Controller.Interfaces.EntryInformationObserver;
import Model.Interfaces.*;
import StairwayInterfaces.iEntry;
import StairwayInterfaces.iSavingGoal;
import StairwayInterfaces.iSavingsOverview;

import java.util.HashMap;
import java.util.Map;

/**
 * A class that has a overview of all the savings
 * Responsibility: inform when a saving is created, add and remove money from savings and overview Savings
 * Used by: indirectly though iSavingOverView
 * @author Artin
 */
public final class SavingsOverview implements iSavingsRegister, SavingsSubject, EntryInformationObserver, iSavingsOverview {
    Map<String, iSavingGoal> savingGoalHashMap = new HashMap<>();
    private static SavingsOverview savingsInstance;

    /**
     * private constructor so that there will only be one object that oversees all the savings
     */
    private SavingsOverview() {
        EntryInfomrationSubject.add(this);
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
    public void addToSaving(final String category,final  double cost) {
        savingGoalHashMap.get(category).addMoneyToSaving(cost);
    }


    /**
     * Adds a new saving goal
     *
     * @param name name of the new saving goal
     * @param goal the amount that is needed to reach the goal
     */
    @Override
    public void addSavingsGoal(final String name, final iSavingGoal goal) {
        savingGoalHashMap.put(name, goal);
        notifyListeners(name);
    }

    /**
     * adds a object as a listener to this class, so that when something happens they will be notified
     *
     * @param o
     */
    @Override
    public void add(final SavingsObserver o) {
        observers.add(o);
    }

    /**
     * Notifies all observers about a change
     *
     * @param name name a parameter that being sent to an observer
     */
    @Override
    public void notifyListeners(final String name) {
        for (final SavingsObserver o : observers) {
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
    public void update(final String category,final  String type, final double money) {
        if ("Savings".equals(type)) {
            addToSaving(category, money);
        }
    }


    public double getAmountSaved(final String name) {
        return savingGoalHashMap.get(name).getSavingGoalReached();
    }

}
