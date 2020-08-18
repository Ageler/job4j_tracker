package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
            while (run) {
                this.showMenu();
                System.out.print("Select: ");
                int select = Integer.valueOf(scanner.nextLine());
                if (select == 0) {
                    System.out.println("=== Create a new Item ====");
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    Item item = new Item();
                    item.setName(name);
                    tracker.add(item);
                } else if (select == 1) {
                    System.out.println("Show all items");
                    Item[] items = tracker.findAll();
                    for (Item i : items
                    ) {
                        System.out.println("item id: " + i.getId());
                    }
                } else if (select == 2) {
                    System.out.println("Edit item");
                    System.out.print("Input id: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    System.out.print("Input name: ");
                    String name = scanner.nextLine();
                    Item newItem = new Item(id, name);
                    if (tracker.replace(id, newItem)) {
                        System.out.println("Successful replacement!");// вывод об успешности операции
                    } else {
                        System.out.println("Error"); // вывод об ошибке
                    }
                } else if (select == 3) {
                    System.out.println("Delete item");
                    System.out.print("Input id: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    if (tracker.delete(id)) {
                        System.out.println("Successful delete!");// вывод об успешности операции
                    } else {
                        System.out.println("Error");
                    }
                } else if (select == 4) {
                    System.out.println("Find item by Id");
                    System.out.print("Input id: ");
                    int id = Integer.valueOf(scanner.nextLine());
                    Item item = tracker.findById(id);
                    if (item != null) {
                        System.out.println(item);// вывод об успешности операции
                    } else {
                        System.out.println("No such item");
                    }
                } else if (select == 5) {
                    System.out.println("Find items by name");
                    System.out.println("Input name");
                    String name = scanner.nextLine();
                   Item[] items = tracker.findByName(name);
                   if(items.length > 0) {
                       for (Item i : items
                       ) {
                           System.out.println("item id: " + i.getId());
                       }
                   }
                   else System.out.println("Not found");
                } else if (select == 6) {
                    run = false;
                }
            }
        }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item\n" +
                "1. Show all items\n" +
                "2. Edit item\n" +
                "3. Delete item\n" +
                "4. Find item by Id\n" +
                "5. Find items by name\n" +
                "6. Exit Program");

    }

    public static void main(String[] args) {
        StartUI start = new StartUI();
        Tracker testTracker = new Tracker();
        Item testItem = new Item(4, "testitem");
        testTracker.add(testItem);
        Scanner input = new Scanner(System.in);
        start.init(input, testTracker);
    }
}
