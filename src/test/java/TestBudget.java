import Model.BudgetLogic.Budget;
import Model.EntryLogic.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBudget {

        Budget budget;
        int foodCost = 100;
        int householdCost = 100;
        int shoppingCost = 100;
        int transportCost = 100;
        int savingsCost = 100;
        int otherCost = 100;
        String income = "100";
        String zero2= "0";
        int zero = 0;

        @BeforeEach
        public void createNewEntry(){
            budget = new Budget(foodCost,householdCost,shoppingCost,transportCost, savingsCost, otherCost, income);}

//---------------------------------------------GETTERS----------------------------------------------------------------//
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

//---------------------------------------------SETTERS----------------------------------------------------------------//

    @Test
        public void testSetFoodCost(){
            budget.setFoodCost(foodCost);
            assertEquals(budget.getFoodCost(),foodCost);

            budget.setFoodCost(zero);
            assertEquals(budget.getFoodCost(),zero);
        }

        @Test
        public void testSetHouseholdCost(){
            budget.setHouseholdCost(householdCost);
            assertEquals(budget.getHouseholdCost(),householdCost);

            budget.setHouseholdCost(zero);
            assertEquals(budget.getHouseholdCost(),zero);
        }

        @Test
        public void testSetShoppingCost(){
            budget.setShoppingCost(shoppingCost);
            assertEquals(budget.getShoppingCost(),shoppingCost);

            budget.setShoppingCost(zero);
            assertEquals(budget.getShoppingCost(),zero);
        }

        @Test
        public void testSetTransportCost(){
            budget.setTransportCost(transportCost);
            assertEquals(budget.getTransportCost(),transportCost);

            budget.setTransportCost(zero);
            assertEquals(budget.getTransportCost(),zero);
        }

        @Test
        public void testSetSavingCost(){
            budget.setSavingsCost(savingsCost);
            assertEquals(budget.getSavingsCost(),savingsCost);

            budget.setSavingsCost(zero);
            assertEquals(budget.getSavingsCost(),zero);
        }

        @Test
        public void testSetOtherCost(){
            budget.setOtherCost(otherCost);
            assertEquals(budget.getOtherCost(),otherCost);

            budget.setOtherCost(zero);
            assertEquals(budget.getOtherCost(),zero);
        }

        @Test
        public void testSetIncome(){
            budget.setIncome(income);
            assertEquals(budget.getIncome(),income);

            budget.setIncome(zero2);
            assertEquals(budget.getIncome(),zero2);
        }
}
