package Model;

import Model.Interfaces.EntryObserver;
import Model.Interfaces.SavingsObserver;
import Model.Interfaces.SavingsSubject;
import Model.Interfaces.iSavingsRegister;

import java.util.HashMap;

public class SavingsOverview implements iSavingsRegister, SavingsSubject, EntryObserver {
    HashMap<String, SavingGoal> savingGoalHashMap = new HashMap<>();
    private static SavingsOverview savingsInstance;

    private SavingsOverview() {
        EntrySubject.add(this);
    }

    public static SavingsOverview getInstance() {
        if (savingsInstance == null) {
            savingsInstance = new SavingsOverview();
        }
        return savingsInstance;
    }

    public void addToSaving(String category, double cost) {
        savingGoalHashMap.get(category).addMoneyToSaving(cost);
    }


    @Override
    public void addSavingsGoal(String name, SavingGoal goal) {
        savingGoalHashMap.put(name, goal);
        notifyListeners(name);
    }

    @Override
    public void add(SavingsObserver o) {
        observers.add(o);
    }

    @Override
    public void notifyListeners(String name) {
        for (SavingsObserver o : observers) {
            o.update(name);
        }
    }

    @Override
    public void update(String category, String type, double money) {
        if (type.equals("Savings")) {
            addToSaving(category, money);
        }
    }

    @Override
    public void update(Entry entry) {

    }



    public double getAmountSaved(String name){
        return savingGoalHashMap.get(name).savingGoalReached;
    }
}
