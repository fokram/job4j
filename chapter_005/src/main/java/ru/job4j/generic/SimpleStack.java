package ru.job4j.generic;

public class SimpleStack<E> {
    private DynamicLinkedList<E> dll = new DynamicLinkedList();

    public E poll() {
        return dll.poll();
    }

    public void push(E value) {
        dll.add(value);
    }

}
