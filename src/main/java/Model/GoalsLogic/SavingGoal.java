package Model.GoalsLogic;

import StairwayInterfaces.iSavingGoal;
import Model.Interfaces.iSavingsRegister;

/**
 * Saving goals class that creates new goals for savings based on a client input
 * Responsibility: create savingGoal
 * Used by: indirectly though iSavingGoal
 * @author Artin
 */
public class SavingGoal implements iSavingGoal {
    private double savingGoalReached = 0;
    double savingGoal;
    String savingName;

    /**
     * Constructor for a SavingGoal, instanciates the object with various imputs that are relevant to the goal
     *
     * @param savingGoal the amount of money that needs to be saved to reach the goal
     * @param savingName name of the saving goal
     */
    public SavingGoal(double savingGoal, String savingName) {
        this.savingGoal = savingGoal;
        this.savingName = savingName;

        iSavingsRegister register = SavingsOverview.getInstance();
        register.addSavingsGoal(savingName, this);
    }


    /**
     * Money is added to the end savings goal.
     *
     * @param money the amount of money that is added to the saving goal
     */
    public void addMoneyToSaving(double money) {
        savingGoalReached = +money;
    }

    public double getSavingGoalReached() {
        return savingGoalReached;
    }

}

