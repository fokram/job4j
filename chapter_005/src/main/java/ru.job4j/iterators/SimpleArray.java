package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SimpleArray<T> implements Iterable {

    private T[] arr;
    private int currentPosition;

    public SimpleArray(int size) {
        arr = (T[]) new Object[size];
        currentPosition = 0;
    }

    public int getLength() {
        return currentPosition;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int iteratorIndex = 0;

            @Override
            public boolean hasNext() {
                return iteratorIndex < currentPosition;
            }

            @Override
            public Object next() {
                return arr[iteratorIndex++];
            }
        };
    }

    public void add(T model) {
        this.arr[currentPosition++] = model;
    }

    public boolean set(int index, T model) {
        boolean result = false;
        if (index < this.currentPosition) {
            this.arr[index] = model;
            result = true;
        }
        return result;
    }

    public boolean remove(int index) {
        boolean result = false;
        if (index < this.currentPosition) {
            System.arraycopy(this.arr, index + 1, this.arr, index, this.currentPosition-- - index);
            result = true;
        }
        return result;
    }

    public T get(int index) {
        T result = null;
        if (index < this.currentPosition) {
            result = this.arr[index];
        }
        return result;
    }
}
