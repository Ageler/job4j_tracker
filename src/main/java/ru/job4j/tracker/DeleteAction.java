package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Input id: "));
        if (tracker.delete(id)) {
            out.println("Successful delete!"); // вывод об успешности операции
        } else {
            out.println("Error");
        }
        return true;
    }
}
