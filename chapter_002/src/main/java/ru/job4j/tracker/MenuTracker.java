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

    public class AddItem implements UserAction {
        @Override
        public int key() {
            return 0;
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

        @Override
        public String info() {
            return "Add new Item.";
        }
    }

    public class ShowItems implements UserAction {
        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Отображение всех заявок --------------");
            for (Item item:tracker.findAll()) {
                tracker.showItem(item);
            }
        }

        @Override
        public String info() {
            return "Show all items.";
        }
    }

    public class FindItemsByName implements UserAction {
        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по имени --------------");
            String name = input.ask("Введите имя заявки :");
            Item[] items = tracker.findByName(name);
            for (Item item:items) {
                tracker.showItem(item);
            }
        }

        @Override
        public String info() {
            return "Find all item by name.";
        }
    }

    public class FindItemById implements UserAction {
        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Поиск заявки по идендификатору --------------");
            String id = input.ask("Please, provide item id:");
            Item item = tracker.findById(id);
            tracker.showItem(item);
        }

        @Override
        public String info() {
            return "Find item by Id.";
        }
    }

    public class DeleteItem implements UserAction {
        @Override
        public int key() {
            return 3;
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

        @Override
        public String info() {
            return "Delete Item.";
        }
    }

    public class UpdateItem implements UserAction {
        @Override
        public int key() {
            return 2;
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

        @Override
        public String info() {
            return "Edit Item.";
        }
    }

    public class Exit implements UserAction {
        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        }

        @Override
        public String info() {
            return "Exit.";
        }
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem());
        this.actions.add(new ShowItems());
        this.actions.add(new UpdateItem());
        this.actions.add(new DeleteItem());
        this.actions.add(new FindItemById());
        this.actions.add(new FindItemsByName());
        this.actions.add(new Exit());
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
                System.out.println(String.format("%s. %s", action.key(), action.info()));
            }
        }
    }
}