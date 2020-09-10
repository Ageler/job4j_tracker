package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.valueOf(input.askStr("Input id: "));
        if (tracker.delete(id)) {
            System.out.println("Successful delete!");// вывод об успешности операции
        } else {
            System.out.println("Error");
        }
        return true;
    }
}
