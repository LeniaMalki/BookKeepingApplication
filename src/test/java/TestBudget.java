import Model.BudgetLogic.Budget;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBudget {

private Budget budget;

    @Test
    public void test_Budget_default_constructor(){
        budget.setFoodCost(200);
        assertEquals(200,budget.getFoodCost());

      /*  budget.setHouseholdCost(200);
        assertEquals(200,budget.getHouseholdCost());

        budget.setShoppingCost(200);
        assertEquals(200,budget.getShoppingCost());

        budget.setTransportCost(200);
        assertEquals(200,budget.getTransportCost());

        budget.setSavingsCost(200);
        assertEquals(200,budget.getSavingsCost());

        budget.setOtherCost(200);
        assertEquals(200,budget.getOtherCost());*/
    }
}
