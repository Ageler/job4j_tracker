package ru.job4j.tracker;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Input id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            out.println(item.getId());
        } else {
            out.println("No such item");
        }
        return true;
    }
}
