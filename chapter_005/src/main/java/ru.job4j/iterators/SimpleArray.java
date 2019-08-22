package ru.job4j.iterators;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleArray<T> implements Iterable {

    private T[] arr;
    public int ind;

    public SimpleArray(int size) {
        arr = (T[]) new Object[size];
        ind = 0;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < arr.length;
            }

            @Override
            public Object next() {
                return arr[iteratorIndex++];
            }
        };
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }

    public void add(T model) {
        arr[ind++] = model;
    }
    public void set(int index, T model) {
        if (index < ind) {
            arr[index] = model;
        }
    }
    public void remove(int index) {
        if (index < ind) {
            for (int i = index; i < ind - 1; i++) {
                arr[i] = arr[i + 1];
            }
            arr[ind--] = null;
        }
    }
    public T get(int index) {
        T result = null;
        if (index < ind) {
            result = arr[index];
        }
        return result;
    }
}
