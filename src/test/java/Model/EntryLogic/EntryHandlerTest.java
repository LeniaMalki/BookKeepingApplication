package Model.EntryLogic;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntryHandlerTest {
    Entry entry1;
    Entry entry2;
    EntryHandler entryHandler;

    @BeforeEach
    void setUp() {
        entry1 = new Entry(100, "TestEntry", "TestCategory", "TestType");
        entry2 = new Entry(1000, "TestEntry2", "TestCategory2", "TestType2");
    }



    @Test
    void addEntry() {
    }

    @Test
    void removeEntry() {
    }
}