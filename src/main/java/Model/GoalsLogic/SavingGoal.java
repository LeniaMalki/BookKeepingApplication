package Model.GoalsLogic;

import Model.Interfaces.iSavingsRegister;
import javafx.scene.image.Image;

/**
 * Saving goals class that creates new goals for savings based on a users inputs
 *
 * @author Artin
 */
public class SavingGoal {
    iSavingsRegister register = SavingsOverview.getInstance();
    double savingGoalReached = 0;
    double savingGoal;
    String savingName;
    Image image;

    /**
     * Constructor for a SavingGoal, instanciates the object with various imputs that are relevant to the goal
     * @param savingGoal the amount of money that needs to be saved to reach the goal
     * @param savingName name of the saving goal
     * @param image a picture of the goal or just a general savings image.
     */
    public SavingGoal(double savingGoal, String savingName, Image image) {
        this.savingGoal = savingGoal;
        this.savingName = savingName;
        if (image == null) {
            //this can be implemented if you want to choose your own pictures
            //this.image = new Image();
        }
      //  } else this.image = image;
        register.addSavingsGoal(savingName, this);
    }


    /**
     * Money is added to the end savings goal.
     * @param money the amount of money that is added to the saving goal
     */
    public void addMoneyToSaving(double money) {
        savingGoalReached = +money;
    }

    public double getSavingGoalReached() {
        return savingGoalReached;
    }
}
