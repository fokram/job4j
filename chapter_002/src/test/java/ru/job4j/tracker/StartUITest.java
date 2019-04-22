package ru.job4j.tracker;

import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final Tracker tracker = new Tracker();

    private StringBuilder menuString = new StringBuilder()
            .append("0. Add new Item.\n")
            .append("1. Show all items.\n")
            .append("2. Edit Item.\n")
            .append("3. Delete Item.\n")
            .append("4. Find item by Id.\n")
            .append("5. Find all item by name.\n")
            .append("6. Exit.\n");

    // получаем ссылку на стандартный вывод в консоль.
    private final PrintStream stdout = System.out;
    // Создаем буфур для хранения вывода.
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThenTrackerDeleteTheValue() {
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test1 name", "desc1"));
        item = tracker.add(new Item("test2 name", "desc2"));
        item = tracker.add(new Item("test3 name", "desc3"));
        Item[] items = tracker.findByName("test2 name");
        for (Item findItem:items) {
            item = findItem;
        }
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"3", item.getId(), "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что удаленного элемента массива в трекере больше нет.
        assertThat(tracker.findById(item.getId()), is(IsNull.nullValue()));
    }

    @Test
    public void whenFindByIdTheValue() {
        //Напрямую добавляем заявку
        Item item = new Item("test1 name", "desc1");
        tracker.add(item);
        item = new Item("test2 name", "desc2");
        tracker.add(item);
        item.setId("987654");
        item =  new Item("test3 name", "desc3");
        tracker.add(item);
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"4", "987654", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menuString)
                                .append("------------ Поиск заявки по идендификатору --------------\n")
                                .append("ID заявки: 987654; Имя заявки: test2 name; Описание заявки: desc2\n")
                                .toString()
                ));
    }

    @Test
    public void whenFindItemsByName() {
        //Напрямую добавляем заявку
        tracker.add(new Item("test1 name", "desc1"));

        Item item = new Item("test2 name", "desc2");
        tracker.add(item);
        item.setId("222");
        tracker.add(new Item("test3 name", "desc3"));
        item = new Item("test2 name", "desc4");
        tracker.add(item);
        item.setId("444");
        tracker.add(new Item("test5 name", "desc5"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"5", "test2 name", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menuString)
                                .append("------------ Поиск заявки по имени --------------\n")
                                .append("ID заявки: 222; Имя заявки: test2 name; Описание заявки: desc2\n")
                                .append("ID заявки: 444; Имя заявки: test2 name; Описание заявки: desc4\n")
                                .toString()
                ));
    }

    @Test
    public void whenShowAll() {
        //Напрямую добавляем заявку
        Item item = new Item("test1 name", "desc1");
        tracker.add(item);
        item.setId("111");
         item = new Item("test2 name", "desc2");
        tracker.add(item);
        item.setId("222");
         item = new Item("test3 name", "desc3");
        tracker.add(item);
        item.setId("333");
         item = new Item("test4 name", "desc4");
        tracker.add(item);
        item.setId("444");
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"1", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        assertThat(new String(out.toByteArray()),
                is(
                        new StringBuilder()
                                .append(menuString)
                                .append("------------ Отображение всех заявок --------------\n")
                                .append("ID заявки: 111; Имя заявки: test1 name; Описание заявки: desc1\n")
                                .append("ID заявки: 222; Имя заявки: test2 name; Описание заявки: desc2\n")
                                .append("ID заявки: 333; Имя заявки: test3 name; Описание заявки: desc3\n")
                                .append("ID заявки: 444; Имя заявки: test4 name; Описание заявки: desc4\n")
                                .toString()
                ));
    }
}