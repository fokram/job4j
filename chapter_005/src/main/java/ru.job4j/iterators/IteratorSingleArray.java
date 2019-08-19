package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorSingleArray implements Iterator {
    private int[] arr;
    private int index = 0;

    public IteratorSingleArray(int[] arr) {
        this.arr = arr;
    }

    @Override
    public boolean hasNext() {
        while (index < arr.length) {
            if (arr[index] % 2 == 0) {
                break;
            }
            index++;
        }
        return index < arr.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr[index++];
    }
}
