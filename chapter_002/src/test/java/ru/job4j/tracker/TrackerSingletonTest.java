package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerSingletonTest {
    @Test
    public void whenUseFirstSingleton() {
        Tracker tracker = TrackerSingleton1.INSTANCE.tracker;
        Item item = new Item("first", "firstDescription");
        tracker.add(item);
        item = new Item("second", "secondDescription");
        tracker.add(item);
        item = new Item("third", "thirdDescription");
        tracker.add(item);
        item = new Item("third", "fourthDescription");
        tracker.add(item);

        List<Item> itemForDelete = tracker.findByName("third");
        for (Item i:itemForDelete) {
            tracker.delete(i.getId());
        }
        Tracker tracker1 = TrackerSingleton1.INSTANCE.tracker;
        assertThat(tracker1.findAll().size(), is(2));
    }

    @Test
    public void whenUseSecondSingleton() {
        Tracker tracker = TrackerSingleton2.getInstance();
        Item item = new Item("first", "firstDescription");
        tracker.add(item);
        item = new Item("second", "secondDescription");
        tracker.add(item);
        item = new Item("third", "thirdDescription");
        tracker.add(item);
        item = new Item("third", "fourthDescription");
        tracker.add(item);

        Tracker tracker2 = TrackerSingleton2.getInstance();
        assertThat(tracker2.findAll().size(), is(4));
    }

    @Test
    public void whenUseThirdSingleton() {
        Tracker tracker = TrackerSingleton3.getInstance();
        Item item = new Item("first", "firstDescription");
        tracker.add(item);
        item = new Item("second", "secondDescription");
        tracker.add(item);
        item = new Item("third", "thirdDescription");
        tracker.add(item);

        Tracker tracker3 = TrackerSingleton3.getInstance();
        assertThat(tracker3.findAll().size(), is(3));
    }

    @Test
    public void whenUseFourthSingleton() {
        Tracker tracker = TrackerSingleton4.getInstance();
        Item item = new Item("first", "firstDescription");
        tracker.add(item);
        item = new Item("second", "secondDescription");
        tracker.add(item);
        item = new Item("third", "thirdDescription");
        tracker.add(item);
        item = new Item("third", "fourthDescription");
        tracker.add(item);
        item = new Item("third", "fourthDescription");
        tracker.add(item);

        Tracker tracker4 = TrackerSingleton4.getInstance();
        assertThat(tracker4.findAll().size(), is(5));
    }
}