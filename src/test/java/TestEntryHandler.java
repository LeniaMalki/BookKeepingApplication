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
    public void setUp() {
        shopping = new Entry(20,"Jeans","Shopping","Expense");
        transport = new Entry(10,"Uber","Transportation","Expense");
        food = new Entry(10,"McDonalds","Food","Expense");
    }

    @AfterEach
    public void tearDownAfterEach() {
        entryHandler.getEntries().clear();
    }

    @Test
    public void testAddingEntryToList() {
        entryHandler.addEntry(shopping);
        entryHandler.addEntry(food);
        Assertions.assertTrue(entryHandler.getEntries().get(0) == shopping && entryHandler.getEntries().get(1) == food);
    }

    @Test
    public void testRemovingEntryToList() {
        entryHandler.addEntry(transport);
        entryHandler.addEntry(shopping);
        entryHandler.removeEntry(transport);
        Assertions.assertEquals(entryHandler.getEntries().size(), 1);
    }

    @Test
    public void testGetInstance() {
        EntryHandler entryHandlerNew = EntryHandler.getInstance();
        Assertions.assertEquals(entryHandler, entryHandlerNew);
    }
    @Test
    public void updateGraphTest(){
        //entryHandler adds the entries to the list of entries and updates values
        entryHandler.addEntry(shopping);
        entryHandler.addEntry(transport);
        entryHandler.addEntry(food);
        entryHandler.updateGraph();

        //Removes one entry and updates values
        entryHandler.removeEntry(transport);
        entryHandler.updateGraph();
        //Checks if the sum of the category of Shopping is now 10 & if all amounts together are 20
        Assertions.assertEquals(entryHandler.getShoppingAmount()+entryHandler.getFoodAmount()+entryHandler.getTransportationAmount(),30);


    }
}
