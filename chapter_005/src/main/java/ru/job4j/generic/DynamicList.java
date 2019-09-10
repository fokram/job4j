package ru.job4j.generic;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicList<E> implements Iterable<E> {
    private Object[] container = new Object[10];
    private int index = 0;
    private int modCount = 0;

    private void extendArray(int extendedSize) {
        this.container = Arrays.copyOf(this.container, this.container.length + extendedSize);
    }

    public void add(E value) {
        if (this.container.length - 1 <= this.index) {
            extendArray(10);
        }
        this.container[this.index++] = value;
        modCount++;
    }

    public E get(int index) {
        E result = null;
        if (index <= this.index) {
            result = (E) container[index];
        }
        return result;
    }

    protected int getSize() {
        return this.container.length;
    }
    @Override
    public Iterator<E> iterator() {
        int fixedModCount = this.modCount;
        return new Iterator<E>() {
            private int iteratorIndex = 0;
            @Override
            public boolean hasNext() {
                if (fixedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return iteratorIndex < index;
            }

            @Override
            public E next() {
                if (fixedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[iteratorIndex++];
            }
        };
    }
}
