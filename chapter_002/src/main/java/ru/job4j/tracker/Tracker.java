package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Random;

/**
 * @version 1
 * @since 10.04.2019
 */
public class Tracker {
    /**
     * Массив для хранение заявок.
     */
    private final Item[] items = new Item[100];

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

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
        this.items[this.position++] = item;
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
        for (int n = 0; n < this.position; n++) {
            if (items[n].getId().equals(id)) {
                items[n] = item;
                items[n].setId(id);
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
        while (n < this.position) {
            if (items[n].getId().equals(id)) {
                System.arraycopy(items, n + 1, items, n, items.length - n - 1);
                result = true;
                this.position--;
                break;
            }
            n++;
        }
        return result;
    }

    /**
     * Метод реализаущий отдающий все заполненные заявки
     */
    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

    /**
     * Метод реализаущий поиск списка заявок по имени
     * @param key имя заявки
     *
     * @return возвращаем массив найденных заявок
     */
    public Item[] findByName(String key) {
        Item[] matchedItems = new Item[this.position];
        int n = 0;
        for (Item item : items) {
            if (item == null) {
                break;
            }
            if (item.getName().equals(key)) {
                matchedItems[n++] = item;
            }
        }
        return Arrays.copyOf(matchedItems, n);
    }

    /**
     * Метод реализаущий поиск заявок по id
     * @param id идентификатор заявки
     *
     * @return возвращаем найденную заявку
     */
    public Item findById(String id) {
        Item result = null;
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                result = items[i];
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