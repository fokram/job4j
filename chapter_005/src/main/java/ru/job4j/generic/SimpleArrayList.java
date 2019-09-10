package ru.job4j.generic;

public class SimpleArrayList<E> {

    private int size = 0;
    private Node<E> first;

    /**
     * Метод вставляет в начало списка данные.
     */
    public void add(E data) {
        Node<E> newLink = new Node<>(data);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
     * Реализовать метод удаления первого элемент в списке.
     */
    public E delete(int index) {
        E deletedItem = null;
        if (this.size > index) {
            deletedItem = get(index);
            if (index == 0) {
                this.first = this.first.next;
            } else if (index == this.size - 1) {
                getNode(index - 1).next = null;
            } else {
                getNode(index - 1).next = getNode(index + 1);
            }
            this.size--;
        }
        return deletedItem;
    }

    /**
     * Метод получения элемента по индексу.
     */
    public Node<E> getNode(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result;
    }
    public E get(int index) {
        return getNode(index).data;
    }

    /**
     * Метод получения размера коллекции.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {

        E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }
}
