package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item i : items
        ) {
            System.out.println("item id: " + i.getId());
        }
        return true;
    }
}
