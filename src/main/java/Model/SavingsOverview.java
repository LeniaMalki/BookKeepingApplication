package Model;

import java.util.HashMap;

public class SavingsOverview {
    HashMap<String, SavingGoal> savingGoalHashMap = new HashMap<>();
    private static SavingsOverview savingsInstance;

    private SavingsOverview() {
    }

    public static SavingsOverview getInstance() {
        if (savingsInstance == null) {
            savingsInstance = new SavingsOverview();
        }
        return savingsInstance;
    }

    public void addToSaving(String category, int cost){
        savingGoalHashMap.get(category).addMoneyToSaving(cost);
    }


}
