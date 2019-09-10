package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicLinkedListTest {

    DynamicLinkedList<String> dynLinkedList = new DynamicLinkedList<String>();

    @Before
    public void setUp() {
        dynLinkedList.add("first");
        dynLinkedList.add("second");
        dynLinkedList.add("third");
        dynLinkedList.add("fourth");
        dynLinkedList.add("five");
        dynLinkedList.add("six");
        dynLinkedList.add("seven");
        dynLinkedList.add("eight");
        dynLinkedList.add("nine");
    }

    @Test
    public void whenAddThenExtendedArray() {
        assertThat(dynLinkedList.getSize(), is(9));
        dynLinkedList.add("ten");
        assertThat(dynLinkedList.getSize(), is(10));
    }

    @Test
    public void whenTryGetSecondReturnSecond() {
        assertThat(dynLinkedList.get(1), is("second"));
    }

    @Test
    public void iterator() {
        boolean thrown = false;
        Iterator it = dynLinkedList.iterator();
        assertThat(it.hasNext(), is(true));
        dynLinkedList.add("ten");
        try {
            it.hasNext();
        } catch (ConcurrentModificationException cme) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }

}