package ru.job4j.generic;

import org.junit.Test;
import org.junit.Before;
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
}