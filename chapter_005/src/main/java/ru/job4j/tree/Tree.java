package ru.job4j.tree;

import java.util.*;

public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    private Node<E> root;
    private int modCount;

    public Tree(E root) {
        this.root = new Node<>(root);
        this.modCount = 0;
    }

    @Override
    public boolean add(E parent, E child) {
        Optional<Node<E>> foundedParent = this.findBy(parent);
        boolean childIsPresented = false;
        if (foundedParent.isPresent()) {
            for (Node<E> chld : foundedParent.get().leaves()) {
                if (chld.eqValue(child)) {
                    childIsPresented = true;
                    break;
                }
            }
        }
        if (foundedParent.isPresent() & !childIsPresented) {
            foundedParent.get().add(new Node<>(child));
            modCount++;
        }
        return false;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<E> iterator() {
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(root);
        return new Iterator<>() {
            private Node<E> current = root;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                return !data.isEmpty();
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                this.current = data.poll();
                data.addAll(current.leaves());
                return current.getValue();
            }
        };
    }
}
