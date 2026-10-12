package org.example;

import java.util.List;
import java.util.Scanner;

public class ToDoApp {
    public static void main(String[] args) {
        ToDoList todo = new ToDoList();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Commands: add <text> | list | remove <i> | done <i> | search <q> | clear | exit");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+", 2);
            String cmd = parts[0].toLowerCase();
            String arg = parts.length > 1 ? parts[1] : "";

            switch (cmd) {
                case "add" -> todo.add(arg);
                case "list" -> printList(todo.getAll());
                case "remove" -> handleIndex(arg, todo::remove);
                case "done" -> handleIndex(arg, todo::done);
                case "search" -> printList(todo.search(arg));
                case "clear" -> todo.clear();
                case "exit" -> { System.out.println("Bye"); return; }
                default -> System.out.println("Unknown command: " + cmd);
            }
        }
    }

    private static void handleIndex(String arg, java.util.function.IntPredicate action) {
        try {
            if (!action.test(Integer.parseInt(arg))) {
                System.out.println("Invalid index");
            }
        } catch (NumberFormatException e) {
            System.out.println("Index must be a number");
        }
    }

    private static void printList(List<ToDoItem> items) {
        if (items.isEmpty()) {
            System.out.println("(empty)");
            return;
        }
        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ": " + items.get(i));
        }
    }
}