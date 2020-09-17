package ru.job4j.tracker;

public class ShowAllItemsAction implements UserAction {

    private final Output out;

    public ShowAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (Item i : items
        ) {
            out.println("item id: " + i.getId());
        }
        return true;
    }
}
