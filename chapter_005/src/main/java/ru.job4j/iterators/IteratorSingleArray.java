package ru.job4j.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorSingleArray implements Iterator {
    private int[] arr;
    private int index = 0;

    public IteratorSingleArray(int[] arr) {
        this.arr = arr;
    }

    private Integer hasNextReturnIndex() {
        Integer result = null;
        int i = index;
        while (i < arr.length) {
            if (arr[i] % 2 != 0) {
                i++;
            } else {
                result = i++;
                break;
            }
        }
        return result;
    }
    @Override
    public boolean hasNext() {
        boolean result;
        if (hasNextReturnIndex() != null) {
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    @Override
    public Object next() {
        Integer result;
        Integer nextIndex = hasNextReturnIndex();
        if (nextIndex != null) {
            index = nextIndex;
            result = arr[index++];
        } else {
            result = null;
        }
        if (result == null) {
            throw new NoSuchElementException();
        } else {
            return result;
        }
    }
}
