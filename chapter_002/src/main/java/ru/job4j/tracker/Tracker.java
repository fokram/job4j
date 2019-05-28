package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @version 1
 * @since 10.04.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final List<Item> items = new ArrayList<>();

    /**
     * Метод реализаущий добавление заявки в хранилище
     * @param item новая заявка
     *
     * @return возвращаем заявку
     */

    public void showItem(Item item) {
        System.out.println(String.format("ID заявки: %s; Имя заявки: %s; Описание заявки: %s", item.getId(), item.getName(), item.getDesc()));
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Метод реализаущий правку заявки в хранилище
     * @param id идентификатор заявки для изменения
     * @param item заявка взамен предыдущей
     *
     * @return возвращаем true если замена успешна и наоборот
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int n = 0; n < items.size(); n++) {
            if (items.get(n).getId().equals(id)) {
                items.set(n, item);
                items.get(n).setId(id);
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод реализаущий удаление заявки в хранилище
     * @param id идентификатор заявки для удаления
     *
     * @return возвращаем true если удаление успешна и наоборот
     */
    public boolean delete(String id) {
        int n = 0;
        boolean result = false;
        while (n < items.size()) {
            if (items.get(n).getId().equals(id)) {
                items.remove(n);
                result = true;
                break;
            }
            n++;
        }
        return result;
    }

    /**
     * Метод реализаущий отдающий все заполненные заявки
     */
    public List<Item> findAll() {
        return items;
    }

    /**
     * Метод реализаущий поиск списка заявок по имени
     * @param key имя заявки
     *
     * @return возвращаем массив найденных заявок
     */
    public List<Item> findByName(String key) {
        List<Item> matchedItems = new ArrayList<Item>();

        for (Item item : items) {
            if (item.getName().equals(key)) {
                matchedItems.add(item);
            }
        }
        return matchedItems;
    }

    /**
     * Метод реализаущий поиск заявок по id
     * @param id идентификатор заявки
     *
     * @return возвращаем найденную заявку
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) {
                result = items.get(i);
                break;
            }
        }
        return result;
    }

    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описание. Для идентификации нам нужен уникальный ключ.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        Random random = new Random();
        //Реализовать метод генерации.
        return String.valueOf(System.currentTimeMillis() + random.nextInt(100500));
    }
}