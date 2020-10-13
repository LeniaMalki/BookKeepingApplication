import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEntryHandler {
    Entry shopping;
    Entry transport;
    Entry food;
    EntryHandler entryHandler = EntryHandler.getInstance();

    @BeforeEach
    //Before each test we set up different entries that we can use
    public void setUp() {
        shopping = new Entry(20, "Jeans", "Shopping", "Expense");
        transport = new Entry(10, "Uber", "Transportation", "Expense");
        food = new Entry(10, "McDonalds", "Food", "Expense");
    }

    @AfterEach
    //After each test we clear the list of entries
    public void tearDownAfterEach() {
        entryHandler.getEntries().clear();
    }

    @Test
    //Test that checks if we succeed with adding entries to the list
    public void testAddingEntryToList() {
        entryHandler.addEntry(shopping);
        entryHandler.addEntry(food);
        Assertions.assertTrue(entryHandler.getEntries().get(0) == shopping && entryHandler.getEntries().get(1) == food);
    }

    @Test
    //Test that checks if we succeed with removing entries from the list
    public void testRemovingEntryToList() {
        entryHandler.addEntry(transport);
        entryHandler.addEntry(shopping);
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
        entryHandler.addEntry(shopping);
        entryHandler.addEntry(transport);
        entryHandler.addEntry(food);
        entryHandler.updateTotalCategoryValues();

        //Removes one entry and updates values
        entryHandler.removeEntry(transport);
        entryHandler.updateTotalCategoryValues();
        //Checks if the sum of the category of Shopping is now 10 & if all amounts together are 20
        Assertions.assertEquals(entryHandler.getShoppingAmount() +
                entryHandler.getFoodAmount() +
                entryHandler.getTransportationAmount(), 30);


    }
}
