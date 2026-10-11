import org.example.ToDoList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class ToDoListTest {
    @Test
    void addAndList() {
        ToDoList t = new ToDoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().getFirst());
    }
    @Test
    void remove() {
        ToDoList t = new ToDoList();
        t.add("a");
        t.add("b");
        assertTrue(t.remove(0));
        assertEquals(1, t.size());
        assertFalse(t.remove(10));
    }
    @Test
    void addEmptyIgnored() {
        ToDoList t = new ToDoList();
        t.add(" ");
        assertEquals(0, t.size());
    }
}
