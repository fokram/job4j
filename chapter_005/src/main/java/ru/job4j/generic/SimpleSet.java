package ru.job4j.generic;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class SimpleSet<E> implements Iterable<E> {

    DynamicList dl = new DynamicList();

    private boolean alreadyHas(E value) {
        boolean result = false;
        Iterator it = dl.iterator();

        while (it.hasNext()) {
            if (value == it.next()) {
                result = true;
                break;
            }
        }
        return result;
    }

    public void add(E value) {
        if (!alreadyHas(value)) {
            dl.add(value);
        }
    }

    @Override
    public Iterator<E> iterator() {
        return dl.iterator();
    }
}
