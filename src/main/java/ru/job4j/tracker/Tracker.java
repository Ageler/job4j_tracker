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

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        if(indexOf(id) != -1) {
            items[indexOf(id)] = item;
            item.setId(id);
        }
       return indexOf(id) != -1;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        System.arraycopy(items, index + 1, items, index, size - index);
        items[size - 1] = null;
        size--;
        return true;
    }
}