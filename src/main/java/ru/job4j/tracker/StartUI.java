package ru.job4j.tracker;

public class StartUI {
    public static void main(String[] args) {
        Tracker testTracker = new Tracker();
        Item testItem = new Item(4, "testitem");
        testTracker.add(testItem);
        System.out.println(testTracker.findById(1));
    }
}
