import Model.EntryLogic.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEntryHandler {

    @Test
    public void testUpdatePieChart(){
        EntryHandler entryHandler = EntryHandler.getInstance();

        Entry e1 = new Entry(20,"Jeans","Shopping","Expense");
        Entry e2 = new Entry(10,"T-shirt","Shopping","Expense");
        entryHandler.addEntry(e1);
        entryHandler.addEntry(e2);

        entryHandler.updateGraph();
        assertEquals(entryHandler.getShoppingAmount(),30);

        entryHandler.removeEntry(e1);

        entryHandler.updateGraph();
        assertEquals(entryHandler.getShoppingAmount(),10);
    }
}
