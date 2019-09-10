package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DynamicListTest {

    DynamicList<String> dl = new DynamicList<String>();

    @Before
    public void setUp() {
        dl.add("first");
        dl.add("second");
        dl.add("third");
        dl.add("fourth");
        dl.add("five");
        dl.add("six");
        dl.add("seven");
        dl.add("eight");
        dl.add("nine");
    }

    @Test
    public void whenAddThenExtendedArray() {
        assertThat(dl.getSize(), is(10));
        dl.add("ten");
        assertThat(dl.getSize(), is(20));
    }

    @Test
    public void whenTryGetSecondReturnSecond() {
        assertThat(dl.get(1), is("second"));
    }

    @Test
    public void iterator() {
        boolean thrown = false;
        Iterator it = dl.iterator();
        assertThat(it.hasNext(), is(true));
        dl.add("ten");
        try {
            it.hasNext();
        } catch (ConcurrentModificationException cme) {
            thrown = true;
        }
        assertThat(thrown, is(true));
    }
}