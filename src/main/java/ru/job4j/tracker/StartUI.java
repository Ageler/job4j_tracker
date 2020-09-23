package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
        List<Item> items = tracker.findAll();
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
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item i : items
            ) {
                System.out.println("item id: " + i.getId());
            }
        } else System.out.println("Not found");
    }

    public void init(Input input, Tracker tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public  void whenCreateItem() {}

    public void whenReplaceItem() {}

    public void whenDeleteItem() {}

    public void whenExit() {}

    public void whenFindByIdAction() {}

    public void whenFindByNameAction() {}

    public  void whenShowAllItemsAction() {}

    public void whenInvalidExit() {}

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
                actions.add(new CreateAction(output));
                actions.add(new ExitAction());
                actions.add(new FindByIdAction(output));
        actions.add(new FindByNameAction(output));
        actions.add(new ShowAllItemsAction(output));
        actions.add(new ReplaceAction(output));
        actions.add(new DeleteAction(output));
                /* another actions */

        new StartUI(output).init(input, tracker, actions);
    }
}

