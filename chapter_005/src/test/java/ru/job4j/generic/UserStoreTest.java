package ru.job4j.generic;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.iterators.SimpleArray;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class UserStoreTest {

    UserStore us = new UserStore(10);
    @Before
    public void setUp() {
        us.add(new User("first"));
        us.add(new User("second"));
        us.add(new User("third"));
        us.add(new User("fourth"));
    }

    @Test
    public void whenCheckFindById() {
        assertThat(us.findById("third").getId(), is("third"));
    }

    @Test
    public void whenReplaceThenReplaced() {
        boolean thrown = false;

        assertThat(us.replace("third", new User("newThird")), is(true));
        assertThat(us.replace("third", new User("newThird")), Is.is(false));
    }

    @Test
    public void whenDeleteThenArrayDecreased() {
        us.remove("third");
        assertThat(us.getSize(), is(3));
    }


}