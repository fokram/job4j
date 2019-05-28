package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     * @param хранит ссылку на объект .
     */
    private Input input;
    /**
     * @param хранит ссылку на объект .
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLentgh() {
        return this.actions.size();
    }

    public final class AddItem extends BaseAction {

        public AddItem(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item --------------");
            String name = input.ask("Please, provide item name:");
            String desc = input.ask("Please, provide item description:");
            Item item = new Item(name, desc);
            tracker.add(item);
            tracker.showItem(item);
        }
    }

    public final class ShowItems extends BaseAction {
        public ShowItems(final int key, final String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Отображение всех заявок --------------");
            for (Item item:tracker.findAll()) {
                tracker.showItem(item);
            }
        }
    }

    public final class FindItemsByName extends BaseAction {
        public FindItemsByName(final int key, final String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            List<Item> items = tracker.findByName(name);
            for (Item item:items) {
                tracker.showItem(item);
            }
        }
    }

    public final class FindItemById extends BaseAction {
        public FindItemById(final int key, final String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по идендификатору --------------");
            String id = input.ask("Please, provide item id:");
            Item item = tracker.findById(id);
            tracker.showItem(item);
        }
    }

    public final class DeleteItem extends BaseAction {
        public DeleteItem(final int key, final String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Deleting the item --------------");
            String id = input.ask("Введите id удаляемой заявки :");
            if (tracker.delete(id)) {
                System.out.println(String.format("------------ Заявка %s успешно удалена-----------", id));
            } else {
                System.out.println(String.format("------------ Заявка %s не найдена-----------", id));
            }
        }
    }

    public final class UpdateItem extends BaseAction {
        public UpdateItem(final int key, final String name) {
            super(key, name);
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Updating the item --------------");
            String id = input.ask("Введите id заменяемой заявки :");
            Item item = tracker.findById(id);
            if (item == null) {
                System.out.println("Нет такой заявки.");
                return;
            }
            String name = input.ask("Введите новое имя заявки :");
            String desc = input.ask("Введите новое описание заявки :");
            item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println(String.format("------------ Заявка %s успешно изменена-----------", item.getId()));
            }
            tracker.showItem(item);
        }
    }

    public final class Exit extends BaseAction {
        private final StartUI ui;
        public Exit(final int key, final String name, StartUI ui) {
            super(key, name);
            this.ui = ui;
        }
        @Override
        public void execute(Input input, Tracker tracker) {
            this.ui.stop();
        }
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions(StartUI ui) {
        this.actions.add(new AddItem(0, "Add new Item."));
        this.actions.add(new ShowItems(1, "Show all items."));
        this.actions.add(new UpdateItem(2, "Edit Item."));
        this.actions.add(new DeleteItem(3, "Delete Item."));
        this.actions.add(new FindItemById(4, "Find item by Id."));
        this.actions.add(new FindItemsByName(5, "Find all item by name."));
        this.actions.add(new Exit(6, "Exit.", ui));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соотвествующие действие.
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(String.format(action.info()));
            }
        }
    }
}