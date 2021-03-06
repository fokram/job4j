package ru.job4j.tracker;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription");
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2");
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    @Test
    public void whenFindAllWithTwoNullsReturnOtherNotNull() {
        Tracker tracker = new Tracker();
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
        assertThat(tracker.findAll().size(), is(2));
    }
}