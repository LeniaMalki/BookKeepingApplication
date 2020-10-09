import Model.EntryLogic.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntryHandler {

    @Test
    public void testUpdatePieChart(){

        EntryHandler entryHandler = EntryHandler.getInstance();

        Entry shopping1 = new Entry(20,"Jeans","Shopping","Expense");
        Entry shopping2 = new Entry(10,"T-shirt","Shopping","Expense");
        Entry food = new Entry(10,"McDonalds","Food","Expense");

        entryHandler.addEntry(shopping1);
        entryHandler.addEntry(shopping2);
        entryHandler.addEntry(food);
        entryHandler.updateGraph();

        assertEquals(entryHandler.getShoppingAmount(),30);

        entryHandler.removeEntry(shopping1);
        entryHandler.updateGraph();

        assertEquals(entryHandler.getShoppingAmount(),10);
        assertEquals(entryHandler.getShoppingAmount()+entryHandler.getFoodAmount(),20);


    }
}
