package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc", 1));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerDeleteTheValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test1 name", "desc1", 1));
        item = tracker.add(new Item("test2 name", "desc2", 1));
        item = tracker.add(new Item("test3 name", "desc3", 1));
        Item[] items = tracker.findByName("test2 name");
        for (Item findItem:items) {
            item = findItem;
        }
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "1", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что удаленного элемента массива в трекере больше нет.
        assertThat(tracker.findById(item.getId()), is(IsNull.nullValue()));
    }


//    @Test
//    public void whenFindByIdTheValue() {
//        // создаём Tracker
//        Tracker tracker = new Tracker();
//        //Напрямую добавляем заявку
//        Item item = new Item("test1 name", "desc1", 1);
//        tracker.add(item);
//        item = new Item("test2 name", "desc2", 1);
//        tracker.add(item);
//        item.setId("987654");
//        item =  new Item("test3 name", "desc3", 1);
//        tracker.add(item);
//        //создаём StubInput с последовательностью действий(производим замену заявки)
//        Input input = new StubInput(new String[]{"4", "987654", "6"});
//        // создаём StartUI и вызываем метод init()
//        new StartUI(input, tracker).init();
//        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
//        Item expectedItem = tracker.findById("987654"); // оставляем null
//        assertThat(tracker.findById(item.getId()), is(IsNull.nullValue()));
//    }
}