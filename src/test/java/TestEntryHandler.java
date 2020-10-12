<<<<<<< Updated upstream
import Model.EntryLogic.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntryHandler {

    @Test
    public void testUpdateValues(){
        //Gets entryHandler
        EntryHandler entryHandler = EntryHandler.getInstance();
        //Makes three new entries
        Entry shopping1 = new Entry(20,"Jeans","Shopping","Expense");
        Entry shopping2 = new Entry(10,"T-shirt","Shopping","Expense");
        Entry food = new Entry(10,"McDonalds","Food","Expense");
        //entryHandler adds the entries to the list of entries and updates values
        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(shopping2);
        entryHandler.addEntry(food);
        entryHandler.updateGraph();
        //Checks if the sum of the category of Shopping is 30
        assertEquals(entryHandler.getShoppingAmount(),30);
        //Removes one entry and updates values
        entryHandler.removeEntry(shopping1);
        entryHandler.updateGraph();
        //Checks if the sum of the category of Shopping is now 10 & if all amounts together are 20
        assertEquals(entryHandler.getShoppingAmount(),10);
        assertEquals(entryHandler.getShoppingAmount()+entryHandler.getFoodAmount(),20);


    }
=======
import Model.EntryLogic.Entry;
import Model.EntryLogic.EntryHandler;
import org.junit.jupiter.api.*;

public class TestEntryHandler {
    Entry entry1;
    Entry entry2;
    EntryHandler entryHandler = EntryHandler.getInstance();


    @BeforeEach
    public void setUp() {
        entry1 = new Entry(100, "TestEntry", "TestCategory", "TestType");
        entry2 = new Entry(1000, "TestEntry2", "TestCategory2", "TestType2");
    }

    @AfterEach
    public void tearDownAfterEach() {
        entryHandler.getEntries().clear();
    }

    @Test
    public void testAddingEntryToList() {
        entryHandler.addEntry(entry1);
        entryHandler.addEntry(entry2);
        Assertions.assertTrue(entryHandler.getEntries().get(0) == entry1 && entryHandler.getEntries().get(1) == entry2);
    }

    @Test
    public void testRemovingEntryToList() {
        entryHandler.addEntry(entry1);
        entryHandler.addEntry(entry2);
        entryHandler.removeEntry(entry2);
        Assertions.assertEquals(entryHandler.getEntries().size(), 1);
    }

    @Test
    public void testGetInstance() {
        EntryHandler entryHandlerNew = EntryHandler.getInstance();
        Assertions.assertEquals(entryHandler, entryHandlerNew);
    }

>>>>>>> Stashed changes
}
