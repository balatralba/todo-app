package org.example;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class ToDoListTest {

    @Test
    void addAndList() {
        ToDoList t = new ToDoList();
        t.add(" task1 ");
        assertEquals(1, t.size());
        assertEquals("task1", t.getAll().get(0).getText());
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
        t.add(null);
        assertEquals(0, t.size());
    }

    @Test
    void clearRemovesAll() {
        ToDoList t = new ToDoList();
        t.add("a");
        t.add("b");
        t.add("c");
        assertEquals(3, t.size());
        t.clear();
        assertEquals(0, t.size());
        assertTrue(t.getAll().isEmpty());
    }

    @Test
    void clearOnEmptyDoesNothing() {
        ToDoList t = new ToDoList();
        t.clear();
        assertEquals(0, t.size());
    }

    @Test
    void doneMarksItem() {
        ToDoList t = new ToDoList();
        t.add("task");
        assertFalse(t.getAll().get(0).isDone());
        assertTrue(t.done(0));
        assertTrue(t.getAll().get(0).isDone());
    }

    @Test
    void doneOutOfBounds() {
        ToDoList t = new ToDoList();
        t.add("task");
        assertFalse(t.done(-1));
        assertFalse(t.done(1));
        assertFalse(t.getAll().get(0).isDone());
    }

    @Test
    void searchFindsSubstring() {
        ToDoList t = new ToDoList();
        t.add("Buy milk");
        t.add("Buy bread");
        t.add("Walk the dog");
        List<ToDoItem> results = t.search("buy");
        assertEquals(2, results.size());
    }

    @Test
    void searchCaseInsensitive() {
        ToDoList t = new ToDoList();
        t.add("Task");
        assertEquals(1, t.search("TASK").size());
        assertEquals(1, t.search("task").size());
    }

    @Test
    void searchEmptyOrNullReturnsEmpty() {
        ToDoList t = new ToDoList();
        t.add("something");
        assertTrue(t.search("").isEmpty());
        assertTrue(t.search("   ").isEmpty());
        assertTrue(t.search(null).isEmpty());
    }

    @Test
    void searchNoMatch() {
        ToDoList t = new ToDoList();
        t.add("abc");
        assertTrue(t.search("xyz").isEmpty());
    }
}