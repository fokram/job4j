package ru.job4j.generic;

public class SimpleQueue<E> {
    private SimpleStack<E> stack = new SimpleStack();
    private SimpleStack<E> queue = new SimpleStack();

    public E poll() {
        if (queue.getSize() == 0) {
            while (stack.getSize() != 0) {
                queue.push(stack.poll());
            }
        }
        E result = null;
        if (queue.getSize() != 0) {
            result = queue.poll();
        }
        return result;
    }

    public void push(E value) {
        stack.push(value);
    }

    public int getSize() {
        return stack.getSize();
    }

}
