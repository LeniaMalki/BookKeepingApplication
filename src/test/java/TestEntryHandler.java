import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEntryHandler {
    Entry shopping1;
    Entry shopping2;
    Entry food;
    EntryHandler entryHandler = EntryHandler.getInstance();

    @BeforeEach
    public void setUp() {
        shopping1 = new Entry(20,"Jeans","Shopping","Expense");
        shopping2 = new Entry(10,"T-shirt","Shopping","Expense");
        food = new Entry(10,"McDonalds","Food","Expense");
    }

    @AfterEach
    public void tearDownAfterEach() {
        entryHandler.getEntries().clear();
    }

    @Test
    public void testAddingEntryToList() {
        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(food);
        Assertions.assertTrue(entryHandler.getEntries().get(0) == shopping1 && entryHandler.getEntries().get(1) == food);
    }

    @Test
    public void testRemovingEntryToList() {
        entryHandler.addEntry(shopping2);
        entryHandler.addEntry(shopping1);
        entryHandler.removeEntry(shopping2);
        Assertions.assertEquals(entryHandler.getEntries().size(), 1);
    }

    @Test
    public void testGetInstance() {
        EntryHandler entryHandlerNew = EntryHandler.getInstance();
        Assertions.assertEquals(entryHandler, entryHandlerNew);
    }
    @Test
    public void testUpdateValues(){
        //entryHandler adds the entries to the list of entries and updates values
        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(shopping2);
        entryHandler.addEntry(food);
        entryHandler.updateGraph();

        //Removes one entry and updates values
        entryHandler.removeEntry(shopping1);
        entryHandler.updateGraph();
        //Checks if the sum of the category of Shopping is now 10 & if all amounts together are 20
        Assertions.assertEquals(entryHandler.getShoppingAmount()+entryHandler.getFoodAmount(),20);


    }
}
