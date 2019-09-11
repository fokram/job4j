package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayListTest {

    private SimpleArrayList<Integer> list;

    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }

    @Test
    public void whenDeleteThenUseGetOneResultTwo() {
        assertThat(list.delete(0), is(3));
        assertThat(list.getSize(), is(2));
    }

    @Test
    public void whenDeleteEmptyArrayThenNull() {
        SimpleArrayList<Integer> list2 = new SimpleArrayList<>();
        assertThat(list2.delete(0), is((Integer) null));
    }

    @Test
    public void whenDeleteMiddleDeletedAccuracty() {
        assertThat(list.delete(1), is(2));
        list.delete(1);
        assertThat(list.getSize(), is(1));
    }

    @Test
    public void whenCycleThenFoundIt() {
        class Node<E> {
            private E data;
            private Node<E> next;

            Node(E data) {
                this.data = data;
            }

            public boolean hasCycle(Node first) {
                boolean isCycle = false;
                DynamicList<Node> dl = new DynamicList();
                Node currentChecked = first;
                while (currentChecked.next != null
                        && !isCycle) {
                    Iterator it = dl.iterator();
                    while (it.hasNext()) {
                        if (it.next() == currentChecked) {
                            isCycle = true;
                            break;
                        }
                    }
                    if (!isCycle) {
                        dl.add(currentChecked);
                        currentChecked = currentChecked.next;
                    }
                }
                return isCycle;
            }
        }

        Node first = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;
        assertThat(first.hasCycle(first), is(false));
        fourth.next = second;
        assertThat(first.hasCycle(first), is(true));
        third.next = second;
        assertThat(first.hasCycle(first), is(true));
    }
}