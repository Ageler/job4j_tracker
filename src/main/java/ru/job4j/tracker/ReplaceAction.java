package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    ConsoleOutput out = new ConsoleOutput();

    @Override
    public String name() {
        return "Update item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id:"));
        String name = input.askStr("Enter a new name of item: ");
        Item item = new Item();
        item.setName(name);
        item.setId(id);
        if (tracker.replace(id, item)) {
            out.println("Successful replacement!");// вывод об успешности операции
        } else {
            out.println("Error"); // вывод об ошибке
        }
        return true;
    }
}
