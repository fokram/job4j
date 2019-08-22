package ru.job4j.iterators;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    SimpleArray<String> sa;
    @Before
    public void setUp() {
        sa = new SimpleArray(10);
        sa.add("first");
        sa.add("second");
        sa.add("third");
        sa.add("fourth");
    }

    @Test
    public void whenAddingThenGetValue() {
        assertThat(sa.get(3), is("fourth"));
    }

    @Test
    public void whenRemoveThanMoveElementDown() {
        sa.remove(0);
        assertThat(sa.get(3), is((String) null));
        assertThat(sa.get(0), is("second"));
        sa.set(3, "fifth");
        assertThat(sa.get(3), is((String) null));

        assertThat(sa.get(2), is("fourth"));
        sa.set(2, "fifth");
        assertThat(sa.get(2), is("fifth"));
    }

    @Test
    public void testIterate() {
        Iterator<String> it = sa.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("first"));
    }
}