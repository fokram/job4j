package ru.job4j.generic;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

public class DynamicLinkedList<E> implements Iterable<E> {
    private SimpleArrayList<E> linkedList = new SimpleArrayList<E>();
    private int modCount;

    public void add(E value) {
        linkedList.add(value);
        modCount++;
    }

    public E get(int index) {
        E result = null;
        if (index < linkedList.getSize()) {
            result = (E) linkedList.get(linkedList.getSize() - index - 1);
        }
        return result;
    }

    public E pollStack() {
        E result = null;
        if (linkedList.getSize() != 0) {
            result = linkedList.delete(0);
        }
        return result;
    }

//    public E pollQueue() {
//        E result = null;
//        if (linkedList.getSize() != 0) {
//            result = linkedList.delete(linkedList.getSize() - 1);
//        }
//        return result;
//    }

    public void delete(int index) {
        linkedList.delete(index);
    }

    protected int getSize() {
        return linkedList.getSize();
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
                return iteratorIndex < linkedList.getSize();
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
