package ru.job4j.tracker;

/**
 * @version 1
 * @since 12.04.2019
 */
public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
    private static final int ADD = 0;
    /**
     * Константа меню для отображения всех существующих заявок.
     */
    private static final int SHOWALL = 1;
    /**
     * Константа меню для правки заявки.
     */
    private static final int EDIT = 2;
    /**
     * Константа меню для удаления заявки.
     */
    private static final int DELETE = 3;
    /**
     * Константа меню для поиска заявки по ID.
     */
    private static final int FINDBYID = 4;
    /**
     * Константа меню для поиска заявки по имени.
     */
    private static final int FINDBYNAME = 5;
    /**
     * Константа меню для выхода.
     */
    private static final int EXIT = 6;

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            int answer = Integer.parseInt(this.input.ask("Выберите пункт меню: "));
            switch (answer) {
                case ADD: this.createItem(); break;
                case SHOWALL: this.showAllItem(); break;
                case EDIT: this.editItem(); break;
                case DELETE: this.deleteItem(); break;
                case FINDBYID: this.findByIdItem(); break;
                case FINDBYNAME: this.findByNameItem(); break;
                case EXIT: exit = true; break;
                default: System.out.println("Нет такого пункта меню, будьте внимательнее.");

            }
        }
    }

    /**
     * Метод реализует добавленяи новый заявки в хранилище.
     */
    private void createItem() {
        System.out.println("------------ Добавление новой заявки --------------");
        String name = this.input.ask("Введите имя заявки :");
        String desc = this.input.ask("Введите описание заявки :");
        Item item = new Item(name, desc, 1);
        this.tracker.add(item);
        System.out.println(String.format("------------ Новая заявка с getId : %s-----------", item.getId()));
    }

    /**
     * Метод реализует отображение заявки
     * @param item на входе заявка
     */
    private void showItem(Item item) {
        System.out.println(String.format("ID заявки: %s; Имя заявки: %s; Описание заявки: %s", item.getId(), item.getName(), item.getDesc()));
    }

    /**
     * Метод реализует отображение всех заявок.
     */
    private void showAllItem() {
        System.out.println("------------ Отображение всех заявок --------------");
        for (Item item:this.tracker.findAll()) {
            showItem(item);
        }
    }

    /**
     * Метод реализует изменение заявки.
     */
    private void editItem() {
        System.out.println("------------ Изменение заявки --------------");
        String id = this.input.ask("Введите id заменяемой заявки :");
        Item item = this.tracker.findById(id);
        if (item == null) {
            System.out.println("Нет такой заявки.");
            return;
        }
        String name = this.input.ask("Введите новое имя заявки :");
        String desc = this.input.ask("Введите новое описание заявки :");
        item = new Item(name, desc, 1);
        if (this.tracker.replace(id, item)) {
            System.out.println(String.format("------------ Заявка %s успешно изменена-----------", item.getId()));
        }
    }

    /**
     * Метод реализует изменение заявки.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки --------------");
        String id = this.input.ask("Введите id удаляемой заявки :");
        if (this.tracker.delete(id)) {
            System.out.println(String.format("------------ Заявка %s успешно удалена-----------", id));
        } else {
            System.out.println(String.format("------------ Заявка %s не найдена-----------", id));
        }
    }

    /**
     * Метод реализует поиск заявки по ID.
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по идендификатору--------------");
        String id = this.input.ask("Введите id заявки :");
        Item item = this.tracker.findById(id);
        showItem(item);
    }

    /**
     * Метод реализует поиск заявки по имени.
     */
    private void findByNameItem() {
        System.out.println("------------ Поиск заявки по имени заявки--------------");
        String name = this.input.ask("Введите имя заявки :");
        Item[] items = this.tracker.findByName(name);
        for (Item item:items) {
            showItem(item);
        }
    }

    /**
     * Метод реализует отображение списка меню
     */
    private void showMenu() {
        System.out.println("Меню.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }
}