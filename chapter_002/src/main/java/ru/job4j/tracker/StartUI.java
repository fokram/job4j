package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @version 1
 * @since 12.04.2019
 */
public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    private final Consumer<String> output;

    private List<Integer> range = new ArrayList<>();

    /**
     * Конструтор инициализирующий поля.
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }
    private boolean working = true;

    public void stop() {
        this.working = false;
    }

    /**
     * Основой цикл программы.
     */
    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions(this);
        for (int i = 0; i < menu.getActionsLentgh(); i++) {
            this.range.add(i);
        }
        do {
            menu.show();
            menu.select((input.ask("select:", this.range)));
        } while (this.working
                && !"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ValidateInput(new ConsoleInput()), new Tracker(), System.out::println).init();
    }
}