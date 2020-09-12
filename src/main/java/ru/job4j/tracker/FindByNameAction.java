package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    ConsoleOutput out = new ConsoleOutput();

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
                out.println("item id: " + i.getId());
            }
        } else out.println("Not found");
        return true;
    }
}
