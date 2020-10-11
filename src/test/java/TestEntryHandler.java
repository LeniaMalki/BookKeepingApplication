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
}
