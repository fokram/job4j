package ru.job4j.iterators;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorSingleArrayTest {

    @Test
    public void arrayHasEvenNumbers() {
        IteratorSingleArray it = new IteratorSingleArray(new int[] {1, 3, 5, 7, 44, 3, 56});
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(44));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(56));
        assertThat(it.hasNext(), is(false));
    }
    @Test
    public void arrayHasntEvenNumbers() {
        boolean thrown = false;
        IteratorSingleArray it = new IteratorSingleArray(new int[] {1, 3, 5, 7, 11});
        try {
            it.next();
        } catch (NoSuchElementException nsee) {
            thrown = true;
        }
        assertThat(thrown, is(true));
        assertThat(it.hasNext(), is(false));
    }

}