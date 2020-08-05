package ru.job4j.tracker;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(new Item[items.length], size);
    }

    public Item[] findByName(String key) {
        int ink = 0;
        Item[] commonItem = new Item[size];
        for (int i = 0; i < size; i++) {
            if(key.equals(items[i].getName())) {
                commonItem[ink] = items[i];
                ink++;
            }
        }
        return commonItem;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}