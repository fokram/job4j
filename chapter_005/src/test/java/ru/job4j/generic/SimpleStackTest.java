package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<String> stack = new SimpleStack<>();

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
        assertThat(stack.poll(), is("nine"));
    }

    @Test
    public void push() {
        stack.push("ten");
        assertThat(stack.getSize(), is(10));
        assertThat(stack.poll(), is("ten"));
        assertThat(stack.getSize(), is(9));
        assertThat(stack.poll(), is("nine"));
        assertThat(stack.getSize(), is(8));
    }
}