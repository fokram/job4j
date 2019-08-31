package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorSingleArray implements Iterator {
    private int[] arr;
    private int index = 0;

    public IteratorSingleArray(int[] arrayInt) {
        this.arr = arrayInt;
    }

    @Override
    public boolean hasNext() {
        while (this.index < this.arr.length) {
            if (this.arr[this.index] % 2 == 0) {
                break;
            }
            this.index++;
        }
        return this.index < this.arr.length;
    }

    @Override
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return this.arr[this.index++];
    }
}
