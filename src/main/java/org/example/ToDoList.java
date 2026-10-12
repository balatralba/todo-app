package org.example;

import java.util.ArrayList;
import java.util.List;

public class ToDoList {
    private final List<ToDoItem> items = new ArrayList<>();

    public void add(String item) {
        if (item != null) {
            item = item.trim();
            if (!item.isEmpty()) {
                items.add(new ToDoItem(item));
            }
        }
    }

    public boolean remove(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
            return true;
        }
        return false;
    }

    public boolean done(int index) {
        if (index >= 0 && index < items.size()) {
            items.get(index).markDone();
            return true;
        }
        return false;
    }

    public void clear() {
        items.clear();
    }

    public List<ToDoItem> search(String query) {
        List<ToDoItem> result = new ArrayList<>();
        if (query == null || query.isBlank()) return result;
        String q = query.trim().toLowerCase();
        for (ToDoItem item : items) {
            if (item.getText().toLowerCase().contains(q)) {
                result.add(item);
            }
        }
        return result;
    }

    public List<ToDoItem> getAll() {
        return new ArrayList<>(items);
    }

    public int size() {
        return items.size();
    }
}