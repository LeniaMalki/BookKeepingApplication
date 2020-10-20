import Model.EntryLogic.iEntry;
import Model.EntryLogic.EntryHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEntryHandler {
    iEntry shopping1;
    iEntry shopping2;
    iEntry transport;
    iEntry food;
    iEntry household;
    iEntry other;
    EntryHandler entryHandler = EntryHandler.getInstance();

    @BeforeEach
    //Before each test we set up different entries that we can use
    public void setUp() {
        shopping1 = new iEntry(20, "Jeans", "Shopping", "Expense");
        shopping2 = new iEntry(40, "T-shirt", "Shopping", "Expense");
        transport = new iEntry(10, "Uber", "Transportation", "Expense");
        food = new iEntry(10, "McDonalds", "Food", "Expense");
        household = new iEntry(30, "Rent", "Household", "Expense");
        other = new iEntry(50, "Cat", "Other", "Expense");

    }

    @AfterEach
    //After each test we clear the list of entries
    public void tearDownAfterEach() {
        entryHandler.getEntries().clear();
    }

    @Test
    //Test that checks if we succeed with adding entries to the list
    public void testAddingEntryToList() {
        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(food);
        Assertions.assertTrue(entryHandler.getEntries().get(0) == shopping1 &&
                                       entryHandler.getEntries().get(1) == food);
    }

    @Test
    //Test that checks if we succeed with removing entries from the list
    public void testRemovingEntryToList() {
        entryHandler.addEntry(transport);
        entryHandler.addEntry(shopping1);
        entryHandler.removeEntry(transport);
        Assertions.assertEquals(entryHandler.getEntries().size(), 1);
    }

    @Test
    //Test that checks the entryHandlers instance
    public void testGetInstance() {
        EntryHandler entryHandlerNew = EntryHandler.getInstance();
        Assertions.assertEquals(entryHandler, entryHandlerNew);
    }

    @Test
    public void updateGraphTest() {
        //entryHandler adds the entries to the list of entries and updates values
        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(shopping2);
        entryHandler.addEntry(transport);
        entryHandler.addEntry(food);
        entryHandler.updateTotalCategoryValues();

        //Removes one entry and updates values
        entryHandler.removeEntry(transport);
        entryHandler.updateTotalCategoryValues();
        //Checks if the sum of the category of Shopping is now 10 & if all amounts together are 20
        Assertions.assertEquals(entryHandler.getShoppingAmount() +
                entryHandler.getFoodAmount() +
                entryHandler.getTransportationAmount(), 70);


    }
    //-------------------------------------------GETTERS--------------------------------------------------------------//

    @Test
    //Test that checks the getter for all entries with category "Food"
    public void testGetFoodAmount() {
        entryHandler.addEntry(food);
        entryHandler.updateTotalCategoryValues();
        Assertions.assertEquals(entryHandler.getFoodAmount(), 10);
    }

    @Test
    //Test that checks the getter for all entries with category "Transportation"
    public void testGetTransportationAmount() {
        entryHandler.addEntry(transport);
        entryHandler.updateTotalCategoryValues();
        Assertions.assertEquals(entryHandler.getTransportationAmount(), 10);
    }

    @Test
    //Test that checks the getter for all entries with category "Household"
    public void testGetHouseholdAmount() {
        entryHandler.addEntry(household);
        entryHandler.updateTotalCategoryValues();
        Assertions.assertEquals(entryHandler.getHouseholdAmount(), 30);
    }

    @Test
    //Test that checks the getter for all entries with category "Shopping"
    public void testGetShoppingAmount() {
        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(shopping2);
        entryHandler.updateTotalCategoryValues();
        Assertions.assertEquals(entryHandler.getShoppingAmount(), 60);
    }

    @Test
    //Test that checks the getter for all entries with category "Other"
    public void testGetOtherAmount() {
        entryHandler.addEntry(other);
        entryHandler.updateTotalCategoryValues();
        Assertions.assertEquals(entryHandler.getOtherAmount(), 50);
    }
}
