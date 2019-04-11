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
     */private int position = 0;

    /**
     * Метод реализаущий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.position++] = item;
        return item;
    }

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

    public Item[] findAll() {
        return Arrays.copyOf(this.items, this.position);
    }

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

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item.getId().equals(id)) {
                result = item;
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