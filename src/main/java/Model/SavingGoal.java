package Model;

import Model.Interfaces.iSavingsRegister;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class SavingGoal {
    iSavingsRegister register= SavingsOverview.getInstance();
    double savingGoalReached = 0;
    int savingGoal;
    String savingName;
    Image image;

    public SavingGoal(int savingGoal, String savingName, Image image) {
        this.savingGoal = savingGoal;
        this.savingName = savingName;
        if (image == null) {
            this.image = new Image("../resources/Images/piggyBank.png");
        } else this.image = image;
        register.addSavingsGoal(savingName,this);
    }

    void addMoneyToSaving(double money) {
        savingGoalReached = +money;
    }

}
