package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    SimpleSet<String> set = new SimpleSet<>();

    @Before
    public void setUp() {
        set.add("one");
        set.add("two");
    }

    @Test
    public void whenAddingDoublesThenNothingAdded() {
        int foundElement = 0;
        set.add("two");
        set.add("two");
        set.add("two");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            if (it.next() == "two") {
                foundElement++;
            }
        }
        assertThat(foundElement, is(1));
    }
}