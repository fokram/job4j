package ru.job4j.generic;

public class SimpleQueue<E> {
    private DynamicLinkedList<E> dll = new DynamicLinkedList();

    public E poll() {
        return dll.pollQueue();
    }

    public void push(E value) {
        dll.add(value);
    }

    public int getSize() {
        return dll.getSize();
    }

}
