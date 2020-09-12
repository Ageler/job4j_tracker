package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    ConsoleOutput out = new ConsoleOutput();

    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Input id: "));
        if (tracker.delete(id)) {
            out.println("Successful delete!");// вывод об успешности операции
        } else {
            out.println("Error");
        }
        return true;
    }
}
