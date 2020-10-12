import Model.BudgetLogic.Budget;
import Model.EntryLogic.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBudget {

        Budget budget;
        int foodCost = 100;
        int zero = 0;

        @BeforeEach
        public void createNewEntry(){
            budget = new Budget(foodCost,100,100,100, 100, 100, "100");
        }
        @Test
        public void testCreationOfFoodCost(){
            Assertions.assertEquals(budget.getFoodCost(), 100);
        }
        @Test
        public void testCreationOfHouseholdCost(){
            Assertions.assertEquals(budget.getHouseholdCost(), 100);
        }
        @Test
        public void testCreationOfShoppingCost(){
            Assertions.assertEquals(budget.getShoppingCost(), 100);
        }
        @Test
        public void testCreationOfTransportCost(){
            Assertions.assertEquals(budget.getTransportCost(), 100);
        }
        @Test
        public void testCreationOfSavingsCost(){
            Assertions.assertEquals(budget.getSavingsCost(), 100);
        }
        @Test
        public void testCreationOfOtherCost(){
            Assertions.assertEquals(budget.getOtherCost(), 100);
        }
        @Test
        public void testCreationOfIncome(){
            Assertions.assertEquals(budget.getIncome(), "100");
        }


        @Test
        public void 
}
