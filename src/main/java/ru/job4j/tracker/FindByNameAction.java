package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Input name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item i : items
            ) {
                out.println("item id: " + i.getId());
            }
        } else {
            out.println("Not found");
        }
        return true;
    }
}
