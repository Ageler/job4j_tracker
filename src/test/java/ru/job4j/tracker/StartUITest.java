package ru.job4j.tracker;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class StartUITest extends TestCase {

    @Test
    public void testCreateItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item();
        expected.setName("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
    @Test
    public void testReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        String[] answers = {
                String.valueOf(item.getId()), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    public void testDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item();
        item.setName("new item");
        tracker.add(item);
        String[] answers = {String.valueOf(item.getId())};
        Item exp = null;
        StartUI.deleteItem(new StubInput(answers), tracker);
       assertThat(tracker.findById(item.getId()), is(exp));
        }

    }
