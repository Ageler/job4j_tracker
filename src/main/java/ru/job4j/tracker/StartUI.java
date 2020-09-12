package ru.job4j.tracker;


import java.util.SplittableRandom;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item();
        item.setName(name);
        tracker.add(item);
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println(" === Update item ====");
        int id = Integer.parseInt(input.askStr("Enter id:"));
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item();
        item.setName(name);
        item.setId(id);
        tracker.replace(id, item);
    }

    public static void showAllItems(Tracker tracker) {
        System.out.println("Show all items");
        Item[] items = tracker.findAll();
        for (Item i : items
        ) {
            System.out.println("item id: " + i.getId());
        }
    }
    public static void  editItem(Input input, Tracker tracker) {
        System.out.println("Edit item");
        int id = Integer.valueOf(input.askStr("Input id: "));
        String name = input.askStr("Input name: ");
        Item newItem = new Item(id, name);
        if (tracker.replace(id, newItem)) {
            System.out.println("Successful replacement!");// вывод об успешности операции
        } else {
            System.out.println("Error"); // вывод об ошибке
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("Delete item");
        int id = Integer.valueOf(input.askStr("Input id: "));
        if (tracker.delete(id)) {
            System.out.println("Successful delete!");// вывод об успешности операции
        } else {
            System.out.println("Error");
        }
    }

    public static void findById(Input input, Tracker tracker) {
        System.out.println("Find item by Id");
        int id = Integer.valueOf(input.askStr("Input id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);// вывод об успешности операции
        } else {
            System.out.println("No such item");
        }
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("Find items by name");
        String name = input.askStr("Input name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item i : items
            ) {
                System.out.println("item id: " + i.getId());
            }
        } else System.out.println("Not found");
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(UserAction[] actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.length; index++) {
            out.println(index + ". " + actions[index].name());
        }
    }

    public  void whenCreateItem() {}

    public void whenReplaceItem() {}

    public void whenDeleteItem() {}

    public void whenExit() {}

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output), new DeleteAction(), new ReplaceAction(), new FindByIdAction(),
                new FindByNameAction(), new ShowAllItemsAction(), new ExitAction()
        };
        new StartUI(output).init(input, tracker, actions);
    }
}

