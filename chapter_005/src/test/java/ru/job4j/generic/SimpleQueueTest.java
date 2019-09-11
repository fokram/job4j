package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    SimpleQueue<String> queue = new SimpleQueue<>();

    @Before
    public void setUp() {
        queue.push("one");
        queue.push("two");
        queue.push("three");
        queue.push("four");
        queue.push("five");
        queue.push("six");
        queue.push("seven");
        queue.push("eight");
        queue.push("nine");
    }

    @Test
    public void poll() {
        assertThat(queue.poll(), is("one"));
        assertThat(queue.poll(), is("two"));
    }

    @Test
    public void push() {
        queue.push("ten");
        assertThat(queue.poll(), is("one"));
        assertThat(queue.poll(), is("two"));
        assertThat(queue.poll(), is("three"));
        assertThat(queue.poll(), is("four"));
        assertThat(queue.poll(), is("five"));
        assertThat(queue.poll(), is("six"));
        assertThat(queue.poll(), is("seven"));
        assertThat(queue.poll(), is("eight"));
        assertThat(queue.poll(), is("nine"));
        queue.push("eleven");
        assertThat(queue.poll(), is("ten"));
        assertThat(queue.poll(), is("eleven"));
        assertThat(queue.poll(), is(nullValue()));
    }
}