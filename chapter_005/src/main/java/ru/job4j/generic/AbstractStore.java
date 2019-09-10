package ru.job4j.generic;

import ru.job4j.iterators.SimpleArray;

import java.util.NoSuchElementException;

public abstract class AbstractStore<T extends Base> implements Store<T> {
    private final SimpleArray<T> sa;

    public AbstractStore(int sizeArray) {
        this.sa = new SimpleArray(sizeArray);
    }

    public int getSize() {
        return sa.getLength();
    }

    public void add(T t) {
        this.sa.add(t);
    }

    private int getArrayIndex(String id) {
        int result = -1;
        int idx = 0;
        while (idx < sa.getLength()) {
            if (sa.get(idx).getId() == id) {
                result = idx;
                break;
            }
            idx++;
        }
        return result;
    }

    @Override
    public boolean replace(String id, T model) {
        boolean result = false;
        int arrayIndex = getArrayIndex(id);
        if (arrayIndex != -1) {
            result = sa.set(arrayIndex, model);
        }
        return result;
    }

    @Override
    public T findById(String id) {
        T result = null;
        int arrayIndex = getArrayIndex(id);
        if (arrayIndex != -1) {
            result = sa.get(arrayIndex);
        }
        return result;
    }

    @Override
    public boolean remove(String id) {
        boolean result = false;
        int arrayIndex = getArrayIndex(id);
        if (arrayIndex != -1) {
            result = sa.remove(arrayIndex);
        }
        return result;
    }
}
