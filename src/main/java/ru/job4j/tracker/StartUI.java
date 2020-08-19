package ru.job4j.tracker;



public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                String name = input.askStr("Enter name: ");
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
                int id = Integer.valueOf(input.askStr("Input id: "));
                String name = input.askStr("Input name: ");
                Item newItem = new Item(id, name);
                if (tracker.replace(id, newItem)) {
                    System.out.println("Successful replacement!");// вывод об успешности операции
                } else {
                    System.out.println("Error"); // вывод об ошибке
                }
            } else if (select == 3) {
                System.out.println("Delete item");
                int id = Integer.valueOf(input.askStr("Input id: "));
                if (tracker.delete(id)) {
                    System.out.println("Successful delete!");// вывод об успешности операции
                } else {
                    System.out.println("Error");
                }
            } else if (select == 4) {
                System.out.println("Find item by Id");
                int id = Integer.valueOf(input.askStr("Input id: "));
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);// вывод об успешности операции
                } else {
                    System.out.println("No such item");
                }
            } else if (select == 5) {
                System.out.println("Find items by name");
                String name = input.askStr("Input name: ");
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item i : items
                    ) {
                        System.out.println("item id: " + i.getId());
                    }
                } else System.out.println("Not found");
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
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}

