import Model.GoalsLogic.SavingGoal;
import Model.GoalsLogic.SavingsOverview;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SavingsOverviewTest {
    static SavingsOverview savingsOverview= SavingsOverview.getInstance();

    @BeforeAll
    static void addSavingGoalTest(){
        SavingGoal goal = new SavingGoal(1000,"testSaving");
        savingsOverview.addSavingsGoal("testGoal",goal );

    }

    @Test
    void getInstance() {
        SavingsOverview testSavings = SavingsOverview.getInstance();
        Assertions.assertEquals(testSavings, savingsOverview);
    }

    @Test
    void addToSaving() {
        savingsOverview.addToSaving("testSaving",100);
        Assertions.assertEquals(savingsOverview.getAmountSaved("testSaving"), 100);
    }

}