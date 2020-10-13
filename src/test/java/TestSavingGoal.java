import Model.GoalsLogic.SavingGoal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestSavingGoal {

    @Test
   public void addMoneyToSaving() {
        SavingGoal savingGoal = new SavingGoal(1000,"testSaving",null);
        savingGoal.addMoneyToSaving(12);
        Assertions.assertEquals(savingGoal.getSavingGoalReached(), 12);
    }

}