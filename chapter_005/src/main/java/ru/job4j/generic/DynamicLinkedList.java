package ru.job4j.generic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicLinkedList<E> implements Iterable<E> {
    private SimpleArrayList<E> linkedList = new SimpleArrayList<E>();
    private int index;
    private int modCount;

    public void add(E value) {
        linkedList.add(value);
        this.index++;
        modCount++;
    }

    public E get(int index) {
        return (E) linkedList.get(this.index - index - 1);
    }

    protected int getSize() {
        return this.index;
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
                return (E) linkedList.get(iteratorIndex++);
            }
        };
    }
}
