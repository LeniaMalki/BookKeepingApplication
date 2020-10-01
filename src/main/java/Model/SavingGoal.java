package Model;

import Model.Interfaces.iSavingsRegister;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class SavingGoal {
    iSavingsRegister register;
    int savingGoalReached = 0;
    int savingGoal;
    String savingName;
    ImageView image;

    public SavingGoal(int savingGoal, String savingName, ImageView image) {
        this.savingGoal = savingGoal;
        this.savingName = savingName;
        if (image == null) {
            this.image.setImage(new Image("/../resources/Images/piggyBank.png"));
        } else this.image = image;
        register.addSavingsGoal(savingName,this);
    }

    void addMoneyToSaving(int money) {
        savingGoalReached = +money;
    }

}
