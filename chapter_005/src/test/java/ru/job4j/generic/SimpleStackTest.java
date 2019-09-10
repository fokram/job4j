package ru.job4j.generic;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleStackTest {
    SimpleStack<String> stack = new SimpleStack<>();

    @Before
    public void setUp() {
        stack.push("first");
        stack.push("second");
        stack.push("third");
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
        assertThat(stack.poll(), is("ten"));
        assertThat(stack.poll(), is("nine"));
        assertThat(stack.poll(), is("eight"));
    }
}