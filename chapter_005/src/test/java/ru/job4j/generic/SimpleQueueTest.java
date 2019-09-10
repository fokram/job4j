package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    SimpleQueue<String> stack = new SimpleQueue<>();

    @Before
    public void setUp() {
        stack.push("one");
        stack.push("two");
        stack.push("three");
        stack.push("fourth");
        stack.push("five");
        stack.push("six");
        stack.push("seven");
        stack.push("eight");
        stack.push("nine");
    }

    @Test
    public void poll() {
        assertThat(stack.poll(), is("one"));
        assertThat(stack.poll(), is("two"));
    }

    @Test
    public void push() {
        stack.push("ten");
        assertThat(stack.getSize(), is(10));
        assertThat(stack.poll(), is("one"));
        assertThat(stack.getSize(), is(9));
        assertThat(stack.poll(), is("two"));
        assertThat(stack.getSize(), is(8));
    }
}