package ru.job4j.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item i : items
            ) {
                System.out.println("item id: " + i.getId());
            }
        } else System.out.println("Not found");
        return true;
    }
}
