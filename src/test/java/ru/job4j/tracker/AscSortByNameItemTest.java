package ru.job4j.tracker;

import junit.framework.TestCase;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AscSortByNameItemTest extends TestCase {

    public void testAscCompare() {
        List<Item> items = Arrays.asList(
                new Item("0"),
                new Item("2"),
                new Item("1")
        );
        Collections.sort(items, new AscSortByNameItem());
        List<Item> exp = Arrays.asList(
                new Item("0"),
                new Item("1"),
                new Item("2")
        );
        assertEquals(exp, items);
    }

    public void testDescCompare() {
        List<Item> items = Arrays.asList(
                new Item("0"),
                new Item("2"),
                new Item("1")
        );
        Collections.sort(items, new DescSortByNameItem());
        List<Item> exp = Arrays.asList(
                new Item("2"),
                new Item("1"),
                new Item("0")
        );
        assertEquals(exp, items);
    }
}