package ru.job4j.generic;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterators.SimpleArray;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RoleStoreTest {

    RoleStore us = new RoleStore(10);
    @Before
    public void setUp() {
        us.add(new Role("first"));
        us.add(new Role("second"));
        us.add(new Role("third"));
        us.add(new Role("fourth"));
    }

    @Test
    public void whenCheckFindById() {
        assertThat(us.findById("third").getId(), is("third"));
    }

    @Test
    public void whenReplaceThenReplaced() {
        boolean thrown = false;

        assertThat(us.replace("third", new Role("newThird")), is(true));

        try {
            us.replace("third", new Role("newThird"));
        } catch (NoSuchElementException nsee) {
            thrown = true;
        }
        assertThat(thrown, Is.is(true));
    }

    @Test
    public void whenDeleteThenArrayDecreased() {
        us.remove("third");
        assertThat(us.getSize(), is(3));
    }


}