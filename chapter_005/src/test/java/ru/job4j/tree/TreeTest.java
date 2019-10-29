package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class TreeTest {
    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(10, 5);
        tree.add(4, 5);
        tree.add(4, 4);
        tree.add(5, 6);
        assertThat(
                tree.findBy(6).isPresent(),
                is(true)
        );
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }

    @Test
    public void testIterator() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 4);
        tree.add(5, 6);
        Iterator it = tree.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        Iterator itn = tree.nodeIterator();
        while (itn.hasNext()) {
            System.out.println(itn.next());
        }

    }

    @Test
    public void checkIsBinary() {

        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(4, 4);
        tree.add(5, 6);
        assertThat(tree.isBinary(), is(true));
        tree.add(4, 3);
        assertThat(tree.isBinary(), is(false));
    }
}