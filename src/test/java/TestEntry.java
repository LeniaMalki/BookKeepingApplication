import Model.EntryLogic.Entry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestEntry {
    Entry entry;

    @BeforeEach
    public void createNewEntry(){
        entry = new Entry(100,"TestEntry","TestCategory","TestType");
    }
    @Test
    public void testCreationOfEntryCost(){
       Assertions.assertEquals(entry.getAmount(), 100);
    }
    @Test
    public void testCreationOfEntryName(){
        Assertions.assertEquals(entry.getName(), "TestEntry");
    }
    @Test
    public void testCreationOfEntryCategory(){
        Assertions.assertEquals(entry.getCategory(), "TestCategory");
    }
    @Test
    public void testCreationOfEntryType(){
        Assertions.assertEquals(entry.getTypeOfEntry(), "TestType");
    }




}
